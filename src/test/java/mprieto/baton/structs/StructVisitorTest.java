package mprieto.baton.structs;

import me.mprieto.baton.exceptions.DuplicateException;
import me.mprieto.baton.exceptions.UnknownTypeException;
import me.mprieto.baton.model.BType;
import me.mprieto.baton.structs.StructVisitor;
import mprieto.baton.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StructVisitorTest {

    @DisplayName("it should throw a DuplicateException")
    @Test
    void duplicateStructTest() {
        var parseTree = TestUtils.fromResource("/structs-duplicated.baton");
        var visitor = new StructVisitor();
        var thrown = assertThrows(DuplicateException.class, () -> visitor.visit(parseTree));

        assertEquals("struct Coordinates already exists. Line: 2", thrown.getMessage());
    }

    @DisplayName("it should throw an UnknownTypeException")
    @Test
    void unknownType() {
        var parseTree = TestUtils.fromResource("/structs-unknown-type.baton");
        var visitor = new StructVisitor();
        var thrown = assertThrows(UnknownTypeException.class, () -> visitor.visit(parseTree));

        assertEquals("Unknown type Coordinates in line 1", thrown.getMessage());
    }

    @DisplayName("it should parse the structs successfully")
    @Test
    void structsParsedSuccessfully() {
        var parseTree = TestUtils.fromResource("/structs-ok.baton");
        var visitor = new StructVisitor();
        var structs = visitor.visit(parseTree);
        assertNotNull(structs);

        var sampleStruct = structs.get("SampleStruct");
        assertNotNull(sampleStruct);

        var name = sampleStruct.get("name");
        assertEquals(BType.STRING, name.getType());

        var coordinatesProp = sampleStruct.get("coordinates");
        assertEquals(BType.IDENTIFIER, coordinatesProp.getType());
        assertEquals("Coordinates", coordinatesProp.getIdentifier());

        var n = sampleStruct.get("n");
        assertEquals(BType.INTEGER, n.getType());

        var output = sampleStruct.get("output");
        assertEquals(BType.OBJECT, output.getType());
        assertNotNull(output.getStruct());

        var nestedStruct = output.getStruct();
        var success = nestedStruct.get("success");
        assertEquals(BType.BOOLEAN, success.getType());

        var message = nestedStruct.get("message");
        assertEquals(BType.STRING, message.getType());

        var coordinatesStruct = structs.get("Coordinates");
        var x = coordinatesStruct.get("x");
        assertEquals(BType.DECIMAL, x.getType());

        var y = coordinatesStruct.get("y");
        assertEquals(BType.DECIMAL, y.getType());
    }

}
