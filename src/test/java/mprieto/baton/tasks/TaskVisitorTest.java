package mprieto.baton.tasks;

import me.mprieto.baton.common.exceptions.DuplicateException;
import me.mprieto.baton.common.exceptions.UnknownTypeException;
import me.mprieto.baton.common.model.BObj;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.tasks.TaskVisitor;
import mprieto.baton.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskVisitorTest {

    @DisplayName("it should throw a DuplicateException")
    @Test
    void duplicateTaskTest() {
        var parseTree = TestUtils.fromResource("/tasks-duplicated.baton");
        var structs = (new StructVisitor()).visit(parseTree);
        var visitor = new TaskVisitor(structs);
        var thrown = assertThrows(DuplicateException.class, () -> visitor.visit(parseTree));

        assertEquals("task HelloWorldTask already exists. Line: 8", thrown.getMessage());
    }

    @DisplayName("it should throw an UnknownTypeException")
    @Test
    void unknownType() {
        var parseTree = TestUtils.fromResource("/tasks-unknown-type.baton");
        var structs = (new StructVisitor()).visit(parseTree);
        var visitor = new TaskVisitor(structs);
        var thrown = assertThrows(UnknownTypeException.class, () -> visitor.visit(parseTree));

        assertEquals("Unknown type Input in line 2", thrown.getMessage());
    }

    @DisplayName("it should parse the tasks successfully")
    @Test
    void tasksParsedSuccessfully() {
        var parseTree = TestUtils.fromResource("/tasks-ok.baton");
        var structs = (new StructVisitor()).visit(parseTree);
        var visitor = new TaskVisitor(structs);
        var tasks = visitor.visit(parseTree);
        assertNotNull(tasks);

        var helloWorldTask = tasks.get("HelloWorldTask");

        var input = helloWorldTask.get("input");
        assertEquals(BObj.ValueType.IDENTIFIER, input.getValueType());
        assertEquals("Input", input.getValue());

        var output = helloWorldTask.get("output");
        assertEquals(BObj.ValueType.IDENTIFIER, output.getValueType());
        assertEquals("Output", output.getValue());

        var description = helloWorldTask.get("description");
        assertEquals(BObj.ValueType.LITERAL_STRING, description.getValueType());
        assertEquals("Simple hello world workflow", description.getValue());


        var retryDelaySeconds = helloWorldTask.get("retryDelaySeconds");
        assertEquals(BObj.ValueType.LITERAL_INTEGER, retryDelaySeconds.getValueType());
        assertEquals(600, retryDelaySeconds.getValue());
    }
}
