package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskType;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.model.BObj;
import me.mprieto.baton.model.BType;
import me.mprieto.baton.model.BVar;
import org.antlr.v4.runtime.Token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StatementVisitor extends Visitor<List<WorkflowTask>> {

    private final BlockVisitor blockVisitor;
    private final CondExprJSVisitor condExprJSVisitor;

    StatementVisitor(VisitorContext vCtx, BlockVisitor blockVisitor) {
        super(vCtx);
        this.blockVisitor = blockVisitor;
        this.condExprJSVisitor = new CondExprJSVisitor(vCtx);
    }

    @Override
    public List<WorkflowTask> visitIfStmt(Baton.IfStmtContext ctx) {
        var ifTask = createIfTask(ctx.parExpression());
        var decisionCases = ifTask.getDecisionCases();
        decisionCases.put("true", blockVisitor.visit(ctx.block(0)));
        if (ctx.block().size() == 2) {
            decisionCases.put("false", blockVisitor.visit(ctx.block(1)));
        }

        return List.of(ifTask);
    }

    @Override
    public List<WorkflowTask> visitWhileStmt(Baton.WhileStmtContext ctx) {
        var whileTask = new WorkflowTask();
        var whileTaskName = implicitVarName("do_while_stmt", ctx.getStart());

        whileTask.setType(TaskType.TASK_TYPE_DO_WHILE);
        whileTask.setName(whileTaskName);
        whileTask.setTaskReferenceName(whileTaskName);
        whileTask.setLoopCondition(condExprJSVisitor.visit(ctx.parExpression()));
        whileTask.setInputParameters(new CondExprInputParamsVisitor(vCtx).visit(ctx.parExpression()));
        //TODO include a way to access the implicit loop task iterator
        whileTask.setLoopOver(blockVisitor.visit(ctx.block()));

        var ifTask = createIfTask(ctx.parExpression());
        ifTask.getDecisionCases().put("true", List.of(whileTask));
        return List.of(ifTask);
    }

    private WorkflowTask createIfTask(Baton.ParExpressionContext ctx) {
        var ifTask = new WorkflowTask();
        var name = implicitVarName("if_stmt", ctx.getParent().getStart());

        ifTask.setType(TaskType.TASK_TYPE_SWITCH);
        ifTask.setEvaluatorType("javascript");
        ifTask.setExpression(condExprJSVisitor.visit(ctx));
        ifTask.setInputParameters(new CondExprInputParamsVisitor(vCtx).visit(ctx));
        ifTask.setName(name);
        ifTask.setTaskReferenceName(name);
        return ifTask;
    }

    @Override
    public List<WorkflowTask> visitVarDeclStmt(Baton.VarDeclStmtContext ctx) {
        var identifier = ctx.IDENTIFIER().getText();
        if ("input".equals(identifier)) {
            throw new RuntimeException("input is an implicit variable for the workflow input");
        }

        if (vCtx.containsVar(identifier)) {
            var v = vCtx.getVar(identifier);
            throw new RuntimeException(String.format("'%s' already declared in line: %d. Line: %d",
                    identifier,
                    v.getCtx().getStart().getLine(),
                    ctx.getStart().getLine()));
        }

        vCtx.addVar(identifier, new BVar(ctx, null, null));

        //TODO this only covers variable declarations when
        // the right expression is a task execution
        // should provide support to my_var := "A String", my_var = false, etc.
        var visited = visit(ctx.expression());
        var setVarTask = createSetVariableTask(identifier,
                ctx.getStart(),
                visited.get(0).getTaskReferenceName());
        return Stream.concat(visited.stream(), Stream.of(setVarTask))
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkflowTask> visitExprStmt(Baton.ExprStmtContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public List<WorkflowTask> visitReturnStmt(Baton.ReturnStmtContext ctx) {
        if (ctx.object() != null) {
            //TODO type check with structDefinitions "workflow.output"
            var objectCtx = ctx.object();
            var retObj = vCtx.objParser().parse(objectCtx);
            var map = convertToMap(retObj);
            vCtx.workflowDef().setOutputParameters(map);
        }

        return List.of();
    }

    // Expressions
    @Override
    public List<WorkflowTask> visitExecuteExpr(Baton.ExecuteExprContext ctx) {
        var varName = getVarName(ctx);
        var taskType = getTaskType(ctx);
        var taskDefinition = vCtx.getTaskDef(taskType);
        var task = new WorkflowTask();

        if (varName != null && taskDefinition != null) {
            var output = taskDefinition.getOutput();
            if (output != null) {
                var variable = vCtx.getVar(varName);
                variable.setType(BType.OBJECT);
                variable.setStruct(getMetadataIOStruct(output));
            }
            task.setTaskReferenceName(varName + "_" + ctx.getStart().getLine());
        } else if (varName != null) {
            var variable = vCtx.getVar(varName);
            variable.setType(BType.UNKNOWN);
            task.setTaskReferenceName(varName + "_" + ctx.getStart().getLine());
        } else {
            varName = implicitVarName(taskType, ctx.getStart());
            task.setTaskReferenceName(varName);
        }


        if (Arrays.stream(TaskType.values()).anyMatch(t -> t.name().toLowerCase().equals(taskType))) {
            task.setType(taskType.toUpperCase());
            task.setName(varName);
        } else {
            task.setType(TaskType.SIMPLE.name());
            task.setName(taskType);
        }


        if (ctx.execParams() != null) {
            loadTaskParams(ctx, taskType, task);
        }

        return List.of(task);
    }

    @Override
    public List<WorkflowTask> visitAssignmentStmt(Baton.AssignmentStmtContext ctx) {
        var visited = visit(ctx.expression());
        var identifier = ctx.IDENTIFIER().getText();
        var setVarTask = createSetVariableTask(identifier,
                ctx.getStart(),
                visited.get(0).getTaskReferenceName());
        return List.of(visited.get(0), setVarTask);
    }

    private static WorkflowTask createSetVariableTask(String identifier, Token ctx, String taskReferenceName) {
        var setVarTask = new WorkflowTask();
        setVarTask.setName(String.format("set_%s_%d", identifier, ctx.getLine()));
        setVarTask.setTaskReferenceName(setVarTask.getName());
        setVarTask.setType(TaskType.SET_VARIABLE.name());
        setVarTask.setInputParameters(Map.of(
                identifier, String.format("${%s.output}", taskReferenceName)));
        return setVarTask;
    }

    // PRIVATE
    private String getVarName(Baton.ExecuteExprContext ctx) {
        if (ctx.getParent() instanceof Baton.VarDeclStmtContext) {
            return ((Baton.VarDeclStmtContext) ctx.getParent()).IDENTIFIER().getText();
        } else if (ctx.getParent() instanceof Baton.AssignmentStmtContext) {
            return ((Baton.AssignmentStmtContext) ctx.getParent()).IDENTIFIER().getText();
        }

        return null;
    }

    private String getTaskType(Baton.ExecuteExprContext ctx) {
        return ctx.IDENTIFIER().getText();
    }

    private void typeCheck(String taskType, BObj input) {
        if (!vCtx.containsTaskDef(taskType)) {
            return;
        }

        var taskDefinition = vCtx.getTaskDef(taskType);
        var taskDefinitionInputProperty = taskDefinition.getInput();
        if (taskDefinitionInputProperty == null) {
            return;
        }

        final var struct = getMetadataIOStruct(taskDefinitionInputProperty);
        for (var prop : input.list()) {
            var s = struct;
            var structProperty = s.get(prop.getName());
            var expectedType = structProperty.getType();
            while (expectedType == BType.IDENTIFIER) {
                s = vCtx.getStruct(structProperty.getIdentifier());
                structProperty = s.get(prop.getName());
                expectedType = structProperty.getType();
            }

            var actualType = getType(prop);
            if (expectedType != actualType) {
                throw new InvalidTypeException(String.format("Expected %s to be %s but got %s. Line: %d",
                        prop.getName(),
                        expectedType,
                        actualType,
                        prop.getCtx().getStart().getLine()));
            }
        }
    }

    private void loadTaskParams(Baton.ExecuteExprContext ctx, String taskType, WorkflowTask task) {
        //TODO complete
        var params = vCtx.objParser().parse(ctx.execParams());
        var inputProperty = params.get("input");
        if (inputProperty != null) {
            if (inputProperty.getType() != BType.OBJECT) {
                throw new InvalidTypeException("Task input must be an Object. " +
                        "Line: " + inputProperty.getCtx().getStart().getLine());
            }

            var inputObj = inputProperty.asBObj();
            typeCheck(taskType, inputObj);
            if (TaskType.HTTP.name().toLowerCase().equals(taskType)) {
                /* Just to avoid "http_request" which was a constant source of confusion with HTTP task.
                 *    "inputParameters": {
                 *       "http_request": {
                 *         "uri": "https://catfact.ninja/fact",
                 *         "method": "GET",
                 *         "connectionTimeOut": 3000,
                 *         "readTimeOut": 3000
                 *       }
                 *    }
                 */
                task.setInputParameters(Map.of("http_request", convertToMap(inputObj)));
            } else {
                task.setInputParameters(convertToMap(inputObj));
            }
        }

        var description = params.get("description");
        if (description != null) {
            task.setDescription(description.asString());
        }

        var startDelay = params.get("startDelay");
        if (startDelay != null) {
            task.setStartDelay(startDelay.asInteger());
        }

        var optional = params.get("optional");
        if (optional != null) {
            task.setOptional(optional.asBoolean());
        }

        var asyncComplete = params.get("asyncComplete");
        if (asyncComplete != null) {
            task.setAsyncComplete(asyncComplete.asBoolean());
        }

        var retryCount = params.get("retryCount");
        if (retryCount != null) {
            task.setRetryCount(retryCount.asInteger());
        }

        //TODO if there's any unsupported param throw an Exception
    }

    private BType getType(BObj.Property prop) {
        if (prop.getType() == BType.IDENTIFIER) {
            // lookup the type
            return getVariableType(prop.asString());
        }

        return prop.getType();
    }

    private BType getVariableType(String identifier) {
        var split = identifier.split("\\.");
        var variable = vCtx.getVar(split[0]);
        var type = variable.getType();

        if (split.length > 1 && type != BType.OBJECT) {
            throw new RuntimeException(String.format("%s is not an Object, cannot access %s", split[0], identifier));
        }

        var struct = variable.getStruct();
        for (int i = 1; i < split.length; i++) {
            var id = split[i];
            if (type != BType.OBJECT) {
                throw new RuntimeException(String.format("%s is not an Object, cannot access %s", id, identifier));
            }

            type = struct.get(id).getType();
            while (type == BType.IDENTIFIER) {
                struct = vCtx.getStruct(id);
                type = struct.get(id).getType();
            }

        }

        return type;
    }
}
