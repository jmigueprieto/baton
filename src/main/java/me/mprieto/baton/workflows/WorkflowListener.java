package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskType;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import me.mprieto.baton.common.BObjParser;
import me.mprieto.baton.common.exceptions.InvalidTypeException;
import me.mprieto.baton.common.exceptions.UnknownSymbolException;
import me.mprieto.baton.common.model.BObj;
import me.mprieto.baton.common.model.BObj.ValueType;
import me.mprieto.baton.common.model.BatonObject;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkflowListener extends BatonBaseListener {

    private final BObjParser objectParser = new BObjParser();

    private final WorkflowDef workflowDef = new WorkflowDef();

    private final Map<String, Object> symbols = new HashMap<>();

    private final Map<String, BObj> taskDefinitions;
    private final Map<String, BStructObj> structDefinitions;

    public WorkflowListener(Map<String, BStructObj> structDefinitions,
                            Map<String, BObj> taskDefinitions) {
        this.structDefinitions = structDefinitions;
        this.taskDefinitions = taskDefinitions;
    }

    public WorkflowDef getWorkflowDef() {
        return this.workflowDef;
    }

    @Override
    public void enterWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx) {
        workflowDef.setName(ctx.IDENTIFIER().getText());
    }

    @Override
    public void enterWorkflowParameters(Baton.WorkflowParametersContext ctx) {
        var parameters = objectParser.parse(ctx.parameters());
        if (parameters.get("description") != null) {
            var desc = parameters.get("description");
            workflowDef.setDescription((String) desc.getValue());
        }

        if (parameters.get("version") != null) {
            var version = parameters.get("version");
            workflowDef.setVersion((Integer) version.getValue());
        }
    }

    @Override
    public void enterWorkflowOutput(Baton.WorkflowOutputContext ctx) {
        // TODO store workflow output type info
    }

    @Override
    public void enterReturnStmt(Baton.ReturnStmtContext ctx) {
        if (ctx.object() == null) {
            return;
        }

        //TODO type check
        var objectCtx = ctx.object();
        var retObj = objectParser.parse(objectCtx);
        var map = convertToMap(retObj);
        workflowDef.setOutputParameters(map);
    }

    @Override
    public void enterVarDeclStmt(Baton.VarDeclStmtContext ctx) {
        symbols.put(ctx.IDENTIFIER().getText(), ctx);
    }

    @Override
    public void enterExecuteExpr(Baton.ExecuteExprContext ctx) {
        var varName = getVarName(ctx);
        var taskType = getTaskType(ctx);
        if (varName == null) {
            varName = taskType + "_" + ctx.getStart().getLine();
        }

        var task = new WorkflowTask();
        if (taskType.equalsIgnoreCase(TaskType.HTTP.name())) {
            task.setType(TaskType.HTTP.name());
            task.setName(varName);
        } else {
            task.setName(varName);
        }
        task.setTaskReferenceName(varName);
        workflowDef.getTasks().add(task);

        if (ctx.taskParameters() != null) {
            var paramsObj = objectParser.parse(ctx.taskParameters().parameters());
            var input = paramsObj.get("input");
            if (input != null) {
                if (input.getValueType() != ValueType.OBJECT) {
                    throw new InvalidTypeException("Task input must be an Object. " +
                            "Line: " + input.getCtx().getStart().getLine());
                }
                var inputObj = (BObj) input.getValue();
                task.setInputParameters(convertToMap(inputObj));
            }
        }
    }

    private List<Object> convertToList(List<BObj> list) {
        return list.stream()
                .map(this::convertToMap)
                .collect(Collectors.toList());
    }

    private Map<String, Object> convertToMap(BObj obj) {
        return obj.list()
                .stream()
                .collect(Collectors.toMap(BatonObject.BProperty::getName, prop -> {
                    var type = prop.getValueType();
                    if (type == ValueType.IDENTIFIER) {
                        return convertIdentifierToRef(prop);
                    } else if (type == ValueType.OBJECT) {
                        return convertToMap(obj);
                    } else if (type == ValueType.ARRAY) {
                        //noinspection unchecked
                        return convertToList((List<BObj>) prop.getValue());
                    }

                    return prop.getValue();
                }));

    }

    private String convertIdentifierToRef(BObj.Property prop) {
        var identifier = (String) prop.getValue();
        var split = identifier.split("\\.");
        var rootObj = split[0];
        if (!rootObj.equalsIgnoreCase("input")) {
            if (!symbols.containsKey(rootObj)) {
                throw new UnknownSymbolException("Unknown symbol " + rootObj +
                        " line " + prop.getCtx().getStart().getLine());
            }
            return String.format("${%s}", identifier);
        } else {
            return String.format("${workflow.%s}", identifier);
        }
    }

    private String getVarName(Baton.ExecuteExprContext ctx) {
        if (ctx.getParent() instanceof Baton.VarDeclStmtContext) {
            return ((Baton.VarDeclStmtContext) ctx.getParent()).IDENTIFIER().getText();
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

    // TODO workflow output and if statement
//
//    @Override
//    public void enterWorkflowOutput(Baton.WorkflowOutputContext ctx) {
//    }
//
//    @Override
//    public void enterIfStmt(Baton.IfStmtContext ctx) {
//        var switchTask = new WorkflowTask();
//
//        switchTask.setName("switch_" + ctx.getStart().getLine() + "_" + ctx.getStart().getCharPositionInLine());
//        switchTask.setType(TaskType.TASK_TYPE_SWITCH);
//        switchTask.setEvaluatorType("javascript");
//        switchTask.setExpression(toJavaScriptExpression(ctx.parExpression()));
//        switchTask.setInputParameters(inputParametersFromExpression(ctx.parExpression()));
//    }
//
//    private Map<String, Object> inputParametersFromExpression(Baton.ParExpressionContext parExpression) {
//        return null;
//    }
//
//    private String toJavaScriptExpression(Baton.ParExpressionContext parExpression) {
//        return null;
//    }
}
