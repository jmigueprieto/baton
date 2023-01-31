package mprieto.baton.tasks;

import me.mprieto.baton.exceptions.DuplicateException;
import me.mprieto.baton.exceptions.UnknownTypeException;
import me.mprieto.baton.model.BType;
import me.mprieto.baton.model.BType;
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
        var taskDefinitions = visitor.visit(parseTree);
        assertNotNull(taskDefinitions);

        var helloWorldTask = taskDefinitions.get("HelloWorldTask");
        assertNull(helloWorldTask.get("input"));
        assertNull(helloWorldTask.get("output"));

        var input = helloWorldTask.getInput();
        assertEquals(BType.IDENTIFIER, input.getType());
        assertEquals("Input", input.getIdentifier());

        var output = helloWorldTask.getOutput();
        assertEquals(BType.IDENTIFIER, output.getType());
        assertEquals("Output", output.getIdentifier());

        var description = helloWorldTask.get("description");
        assertEquals(BType.STRING, description.getType());
        assertEquals("Simple hello world workflow", description.getValue());

        var retryDelaySeconds = helloWorldTask.get("retryDelaySeconds");
        assertEquals(BType.INTEGER, retryDelaySeconds.getType());
        assertEquals(600, retryDelaySeconds.getValue());
    }
}
