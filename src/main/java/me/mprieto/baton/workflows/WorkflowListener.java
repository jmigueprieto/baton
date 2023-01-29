package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskDef;
import com.netflix.conductor.common.metadata.tasks.TaskType;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import me.mprieto.baton.common.BGenericObjectParser;
import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.common.model.BGenericObj;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.Map;
import java.util.Stack;

public class WorkflowListener extends BatonBaseListener {

    private final Map<String, BGenericObj> tasks;
    private final BGenericObjectParser objectParser;
    private final WorkflowDef workflowDef = new WorkflowDef();

    //TODO Stack for WorkflowTask of type Switch
    private final Stack<TaskDef> switchTasksStack = new Stack<>();
    private final Stack<String> varDeclStack = new Stack<>();

    public WorkflowListener(Map<String, BStructObj> structs, Map<String, BGenericObj> tasks) {
        this.objectParser = new BGenericObjectParser(structs);
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

    private Map<String, Object> inputParametersFromExpression(Baton.ParExpressionContext parExpression) {
        return null;
    }

    private String toJavaScriptExpression(Baton.ParExpressionContext parExpression) {
        return null;
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
    public void enterExecute(Baton.ExecuteContext ctx) {
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
    }

    private String getVarName() {
        if (!varDeclStack.isEmpty()) {
            return varDeclStack.peek();
        }

        return null;
    }

    private String getTaskType(Baton.ExecuteContext ctx) {
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
}
