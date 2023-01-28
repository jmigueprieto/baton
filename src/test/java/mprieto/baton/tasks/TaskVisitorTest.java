package mprieto.baton.tasks;

import me.mprieto.baton.common.exceptions.DuplicateException;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.tasks.TaskVisitor;
import mprieto.baton.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
