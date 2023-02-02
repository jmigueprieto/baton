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
        assertEquals(Map.of("message", "${result.output.message}"), workflowDef.getOutputParameters());
        assertEquals(List.of("name"), workflowDef.getInputParameters());

        var tasks = workflowDef.getTasks();
        assertEquals(1, tasks.size());
        var task0 = tasks.get(0);
        assertEquals("result", task0.getName());
        assertEquals("result", task0.getTaskReferenceName());
        assertEquals(TaskType.SIMPLE.name(), task0.getType());
        assertEquals(Map.of("name", "${workflow.input.name}"), task0.getInputParameters());
        assertEquals("GoodByeWorld", workflowDef.getFailureWorkflow());
        assertTrue(workflowDef.isRestartable());
        assertTrue(workflowDef.isWorkflowStatusListenerEnabled());
        assertEquals("hello@mprieto.me", workflowDef.getOwnerEmail());
        assertEquals(WorkflowDef.TimeoutPolicy.TIME_OUT_WF, workflowDef.getTimeoutPolicy());
        assertEquals(1800L, workflowDef.getTimeoutSeconds());
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
}
