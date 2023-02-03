package mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskType;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.tasks.TaskVisitor;
import me.mprieto.baton.workflows.WorkflowVisitor;
import mprieto.baton.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowVisitorTest {

    @DisplayName("it should parse helloworld successfully and populate the WorkflowDef instance")
    @Test
    void helloWorld() {
        var parseTree = TestUtils.fromResource("/helloworld.baton");
        var structDefinitions = (new StructVisitor()).visit(parseTree);
        var taskDefinitions = (new TaskVisitor(structDefinitions)).visit(parseTree);

        var workflowVisitor = new WorkflowVisitor(structDefinitions, taskDefinitions);
        var workflowDef = workflowVisitor.visit(parseTree.workflowDeclaration());

        assertEquals("HelloWorld", workflowDef.getName());
        assertEquals(3, workflowDef.getVersion());
        assertEquals(Map.of("message", "${workflow.variables.result.output.message}"), workflowDef.getOutputParameters());
        assertEquals(List.of("name"), workflowDef.getInputParameters());

        var tasks = workflowDef.getTasks();
        assertEquals(2, tasks.size());

        var simpleTask = tasks.get(0);
        assertEquals("GreetingTask", simpleTask.getName());
        assertEquals("result_26", simpleTask.getTaskReferenceName());
        assertEquals(TaskType.SIMPLE.name(), simpleTask.getType());
        assertEquals(Map.of("name", "${workflow.input.name}"), simpleTask.getInputParameters());
        assertEquals("GoodByeWorld", workflowDef.getFailureWorkflow());
        assertTrue(workflowDef.isRestartable());
        assertTrue(workflowDef.isWorkflowStatusListenerEnabled());
        assertEquals("hello@mprieto.me", workflowDef.getOwnerEmail());
        assertEquals(WorkflowDef.TimeoutPolicy.TIME_OUT_WF, workflowDef.getTimeoutPolicy());
        assertEquals(1800L, workflowDef.getTimeoutSeconds());

        var setVariableTask = tasks.get(1);
        assertEquals("set_result_26", setVariableTask.getName());
        assertEquals("set_result_26", setVariableTask.getTaskReferenceName());
        assertEquals(Map.of("result", String.format("${%s.output}", simpleTask.getTaskReferenceName())),
                setVariableTask.getInputParameters());
        assertEquals(TaskType.SET_VARIABLE.name(), setVariableTask.getType());
    }

    @DisplayName("it should thrown a InvalidTypeException if task input is not of the correct type")
    @Test
    void invalidTaskInput() {
        var parseTree = TestUtils.fromResource("/invalid-task-input.baton");
        var structDefinitions = (new StructVisitor()).visit(parseTree);
        var taskDefinitions = (new TaskVisitor(structDefinitions)).visit(parseTree);

        var workflowVisitor = new WorkflowVisitor(structDefinitions, taskDefinitions);

        var thrown = assertThrows(InvalidTypeException.class, () -> workflowVisitor.visit(parseTree.workflowDeclaration()));

        assertEquals("Expected x to be INTEGER but got STRING. Line: 18", thrown.getMessage());
    }

    @DisplayName("it should generate a switch task for the if statement")
    @Test
    void payment() {
        var parseTree = TestUtils.fromResource("/payment.baton");
        var structDefinitions = (new StructVisitor()).visit(parseTree);
        var taskDefinitions = (new TaskVisitor(structDefinitions)).visit(parseTree);

        var workflowVisitor = new WorkflowVisitor(structDefinitions, taskDefinitions);
        var workflowDef = workflowVisitor.visit(parseTree.workflowDeclaration());

        assertEquals("Payment", workflowDef.getName());
        assertEquals(1, workflowDef.getVersion());
        assertEquals(Map.of(), workflowDef.getOutputParameters());
        assertEquals(List.of("uid", "amount"), workflowDef.getInputParameters());

        var tasks = workflowDef.getTasks();
        assertEquals(3, tasks.size());

        var checkBalanceTask = tasks.get(0);
        assertEquals("CheckBalance", checkBalanceTask.getName());
        assertEquals("balance_2", checkBalanceTask.getTaskReferenceName());
        assertEquals(TaskType.SIMPLE.name(), checkBalanceTask.getType());
        assertEquals(Map.of("uid", "${workflow.input.uid}"), checkBalanceTask.getInputParameters());

        var setVariableTask = tasks.get(1);
        assertEquals("set_balance_2", setVariableTask.getName());
        assertEquals("set_balance_2", setVariableTask.getTaskReferenceName());
        assertEquals(Map.of("balance", "${balance_2.output}"), setVariableTask.getInputParameters());
        assertEquals(TaskType.SET_VARIABLE.name(), setVariableTask.getType());

        var switchTask = tasks.get(2);
        assertNotNull(switchTask.getName());
        assertNotNull(switchTask.getTaskReferenceName());
        assertEquals(TaskType.SWITCH.name(), switchTask.getType());
        assertTrue(switchTask.getDefaultCase().isEmpty());

        var decisionCases = switchTask.getDecisionCases();
        var trueCaseList = decisionCases.get("true");
        assertEquals(1, trueCaseList.size());
        var trueTask = trueCaseList.get(0);
        assertEquals(TaskType.SIMPLE.name(), trueTask.getType());
        assertEquals("PayWithCredit", trueTask.getName());
        var falseCaseList = decisionCases.get("false");
        assertEquals(2, falseCaseList.size());

        var falseTask0 = falseCaseList.get(0);
        assertEquals(TaskType.SIMPLE.name(), falseTask0.getType());
        assertEquals("ErrorEmail", falseTask0.getName());

        var falseTask1 = falseCaseList.get(1);
        assertEquals(TaskType.SIMPLE.name(), falseTask1.getType());
        assertEquals("CancelOrder", falseTask1.getName());
    }

    @DisplayName("it should generate a loop task for the while statement")
    @Test
    void loop() {
        var parseTree = TestUtils.fromResource("/loop.baton");
        var structDefinitions = (new StructVisitor()).visit(parseTree);
        var taskDefinitions = (new TaskVisitor(structDefinitions)).visit(parseTree);

        var workflowVisitor = new WorkflowVisitor(structDefinitions, taskDefinitions);
        var workflowDef = workflowVisitor.visit(parseTree.workflowDeclaration());

        assertEquals("Loop", workflowDef.getName());
        assertEquals(1, workflowDef.getVersion());
        assertEquals(Map.of(), workflowDef.getOutputParameters());
        assertEquals(List.of("uid"), workflowDef.getInputParameters());

        var tasks = workflowDef.getTasks();
        assertEquals(3, tasks.size());

        var getUserById0 = tasks.get(0);
        assertEquals("GetUserByID", getUserById0.getName());
        assertEquals("user_2", getUserById0.getTaskReferenceName());
        assertEquals(TaskType.SIMPLE.name(), getUserById0.getType());
        assertEquals(Map.of("uid", "${workflow.input.uid}"), getUserById0.getInputParameters());

        var setUser0 = tasks.get(1);
        assertEquals("set_user_2", setUser0.getName());
        assertEquals("set_user_2", setUser0.getTaskReferenceName());
        assertEquals(Map.of("user", "${user_2.output}"), setUser0.getInputParameters());
        assertEquals(TaskType.SET_VARIABLE.name(), setUser0.getType());

        // a guard if before the DO WHILE to get a WHILE behaviour
        var guardSwitchTask = tasks.get(2);
        assertEquals(TaskType.SWITCH.name(), guardSwitchTask.getType());
        assertNotNull(guardSwitchTask.getName());
        assertNotNull(guardSwitchTask.getTaskReferenceName());
        assertEquals(TaskType.SWITCH.name(), guardSwitchTask.getType());

        var decisionCases = guardSwitchTask.getDecisionCases();
        var trueCaseList = decisionCases.get("true");
        assertEquals(1, trueCaseList.size());
        assertNull(decisionCases.get("false"));
        assertTrue(guardSwitchTask.getDefaultCase().isEmpty());

        var doWhileTask = trueCaseList.get(0);
        assertEquals("do_while_stmt_3", doWhileTask.getName());
        assertEquals("do_while_stmt_3", doWhileTask.getTaskReferenceName());
        assertEquals(TaskType.DO_WHILE.name(), doWhileTask.getType());
        assertEquals("!$.user.active", doWhileTask.getLoopCondition());

        var loopOver = doWhileTask.getLoopOver();
        assertEquals(2, loopOver.size());

        var getUserById1 = loopOver.get(0);
        assertEquals("GetUserByID", getUserById1.getName());
        assertEquals("user_4", getUserById1.getTaskReferenceName());
        assertEquals(TaskType.SIMPLE.name(), getUserById1.getType());
        assertEquals(Map.of("uid", "${workflow.input.uid}"), getUserById1.getInputParameters());

        var setUser1 = loopOver.get(1);
        assertEquals("set_user_4", setUser1.getName());
        assertEquals("set_user_4", setUser1.getTaskReferenceName());
        assertEquals(Map.of("user", "${user_4.output}"), setUser1.getInputParameters());
        assertEquals(TaskType.SET_VARIABLE.name(), setUser1.getType());
    }
}
