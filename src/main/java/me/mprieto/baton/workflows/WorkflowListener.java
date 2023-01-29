package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskDef;
import com.netflix.conductor.common.metadata.tasks.TaskType;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import me.mprieto.baton.common.BGenericObjectParser;
import me.mprieto.baton.common.exceptions.InvalidTypeException;
import me.mprieto.baton.common.model.BObj;
import me.mprieto.baton.common.model.BObj.ValueType;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class WorkflowListener extends BatonBaseListener {

    private final Map<String, BObj> tasks;

    private final Map<String, BStructObj> structs;
    private final BGenericObjectParser objectParser = new BGenericObjectParser();

    private final WorkflowDef workflowDef = new WorkflowDef();

    //TODO Stack for WorkflowTask of type Switch
    private final Stack<TaskDef> switchTasksStack = new Stack<>();
    private final Stack<String> varDeclStack = new Stack<>();

    //TODO symbol table for variables
    public WorkflowListener(Map<String, BStructObj> structs, Map<String, BObj> tasks) {
        this.structs = structs;
        this.tasks = tasks;
    }

    @Override
    public void enterWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx) {
        workflowDef.setName(ctx.IDENTIFIER().getText());
        if (ctx.workflowParameters() != null) {
            var parameters = objectParser.parse("_", ctx.workflowParameters().parameters());
            if (parameters.get("description") != null) {
                var desc = parameters.get("description");
                workflowDef.setDescription((String) desc.getValue());
            }
        }
        super.enterWorkflowDeclaration(ctx);
    }

    @Override
    public void enterWorkflowOutput(Baton.WorkflowOutputContext ctx) {
        super.enterWorkflowOutput(ctx);
    }

    @Override
    public void enterIfStmt(Baton.IfStmtContext ctx) {
        var switchTask = new WorkflowTask();

        switchTask.setName("switch_" + ctx.getStart().getLine() + "_" + ctx.getStart().getCharPositionInLine());
        switchTask.setType(TaskType.TASK_TYPE_SWITCH);
        switchTask.setEvaluatorType("javascript");
        switchTask.setExpression(toJavaScriptExpression(ctx.parExpression()));
        switchTask.setInputParameters(inputParametersFromExpression(ctx.parExpression()));
    }

    @Override
    public void exitIfStmt(Baton.IfStmtContext ctx) {

    }

    @Override
    public void enterVarDeclStmt(Baton.VarDeclStmtContext ctx) {
        varDeclStack.push(ctx.IDENTIFIER().getText());
    }

    @Override
    public void exitVarDeclStmt(Baton.VarDeclStmtContext ctx) {
        varDeclStack.pop();
    }

    @Override
    public void enterExecuteExpr(Baton.ExecuteExprContext ctx) {
        var varName = getVarName();
        var taskType = getTaskType(ctx);
        if (varName == null) {
            varName = taskType + "_" + ctx.getStart().getLine();
        }

        var task = new WorkflowTask();
        if (taskType.equalsIgnoreCase("http")) {
            task.setType(TaskType.HTTP.name());
            task.setName(varName);
        } else {
            task.setName(varName);
        }
        task.setTaskReferenceName(varName);
        workflowDef.getTasks().add(task);

        if (ctx.taskParameters() != null) {
            var parametersCtx = ctx.taskParameters().parameters();
            var keyValuePairs = parametersCtx.keyValuePair();

            var paramsObj = new BObj(ctx, "taskParams");
            objectParser.loadProperties(paramsObj, keyValuePairs);

            var input = paramsObj.get("input");
            if (input != null) {
                if (input.getValueType() != ValueType.OBJECT) {
                    throw new InvalidTypeException("Task input must be an Object. " +
                            "Line: " + input.getCtx().getStart().getLine());
                }
                var inputObj = (BObj) input.getValue();
                task.setInputParameters(convertTaskInputObjectToMap(inputObj));
            }

        }
    }

    private Map<String, Object> convertTaskInputObjectToMap(BObj inputObj) {
        var map = new HashMap<String, Object>();
        var props = inputObj.list();
        for (var prop : props) {
            var type = prop.getValueType();
            if (type == ValueType.IDENTIFIER) {
                var identifier = (String) prop.getValue();
                var split = identifier.split("\\.");
                var root = split[0];
                if (!root.equals("input")) {
                    //TODO if not in symbol table throw an Exception
                    map.put(prop.getName(), String.format("${%s}", identifier));
                } else {
                    map.put(prop.getName(), String.format("${workflow.%s}", identifier));
                }
            } else if (type == ValueType.LITERAL_STRING || type == ValueType.LITERAL_INTEGER) {
                map.put(prop.getName(), prop.getValue());
            }
        }
        return map;
    }

    private String getVarName() {
        if (!varDeclStack.isEmpty()) {
            return varDeclStack.peek();
        }

        return null;
    }

    private String getTaskType(Baton.ExecuteExprContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return ctx.IDENTIFIER().getText();
        }

        if (ctx.LITERAL_STRING() != null) {
            var str = ctx.LITERAL_STRING().getText();
            return str.substring(1, str.length() - 1);
        }

        throw new RuntimeException("Cannot get task type");
    }

    public WorkflowDef getWorkflowDef() {
        return this.workflowDef;
    }


    private Map<String, Object> inputParametersFromExpression(Baton.ParExpressionContext parExpression) {
        return null;
    }

    private String toJavaScriptExpression(Baton.ParExpressionContext parExpression) {
        return null;
    }
}
