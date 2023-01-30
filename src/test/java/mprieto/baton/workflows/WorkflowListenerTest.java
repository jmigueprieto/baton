package mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskType;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.tasks.TaskVisitor;
import me.mprieto.baton.workflows.WorkflowListener;
import mprieto.baton.TestUtils;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkflowListenerTest {

    @DisplayName("it should parse workflow-0 successfully and populate the WorkflowDef instance")
    @Test
    void workflow0ParsedSuccessfully() {
        var parseTree = TestUtils.fromResource("/workflow-0.baton");
        var structDefinitions = (new StructVisitor()).visit(parseTree);
        var visitor = new TaskVisitor(structDefinitions);
        var taskDefinitions = visitor.visit(parseTree);

        var listener = new WorkflowListener(structDefinitions, taskDefinitions);
        var walker = new ParseTreeWalker();
        walker.walk(listener, parseTree);

        var workflowDef = listener.getWorkflowDef();
        assertEquals("HelloWorld", workflowDef.getName());
        assertEquals(3, workflowDef.getVersion());
        assertEquals(Map.of("message", "${result.output.message}"), workflowDef.getOutputParameters());

        var tasks = workflowDef.getTasks();
        assertEquals(1, tasks.size());
        var task0 = tasks.get(0);
        assertEquals("result", task0.getName());
        assertEquals("result", task0.getTaskReferenceName());
        assertEquals(TaskType.SIMPLE.name(), task0.getType());
        assertEquals(Map.of("name", "${workflow.input.name}"), task0.getInputParameters());
    }
}
