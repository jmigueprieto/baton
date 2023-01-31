package mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskType;
import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.tasks.TaskVisitor;
import me.mprieto.baton.workflows.WorkflowListener;
import mprieto.baton.TestUtils;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WorkflowListenerTest {

    @DisplayName("it should parse workflow-0 successfully and populate the WorkflowDef instance")
    @Test
    void workflow0ParsedSuccessfully() {
        var parseTree = TestUtils.fromResource("/helloworld.baton");
        var structDefinitions = (new StructVisitor()).visit(parseTree);
        var taskDefinitions = (new TaskVisitor(structDefinitions)).visit(parseTree);

        var listener = new WorkflowListener(structDefinitions, taskDefinitions);
        var walker = new ParseTreeWalker();
        walker.walk(listener, parseTree);

        var workflowDef = listener.getWorkflowDef();
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
    }

    @DisplayName("it should thrown a InvalidTypeException if task input is not of the correct type")
    @Test
    void throwsInvalidTypeException() {
        var parseTree = TestUtils.fromResource("/invalid-task-input.baton");
        var structDefinitions = (new StructVisitor()).visit(parseTree);
        var taskDefinitions = (new TaskVisitor(structDefinitions)).visit(parseTree);

        var listener = new WorkflowListener(structDefinitions, taskDefinitions);
        var walker = new ParseTreeWalker();

        var thrown = assertThrows(InvalidTypeException.class, () -> walker.walk(listener, parseTree));

        assertEquals("Expected x to be INTEGER but got STRING. Line: 18", thrown.getMessage());
    }
}
