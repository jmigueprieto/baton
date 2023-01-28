package mprieto.baton.structs;

import me.mprieto.baton.common.exceptions.DuplicateException;
import me.mprieto.baton.common.exceptions.UnknownTypeException;
import me.mprieto.baton.common.model.TypeDef;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.structs.model.BStructObj;
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
        assertEquals(TypeDef.TYPE_STRING, name.getValueType());
        assertNull(name.getValue());

        var coordinatesProp = sampleStruct.get("coordinates");
        assertEquals(TypeDef.TYPE_DEF_STRUCT, coordinatesProp.getValueType());
        assertTrue(coordinatesProp.getValue() instanceof String);

        var n = sampleStruct.get("n");
        assertEquals(TypeDef.TYPE_INTEGER, n.getValueType());
        assertNull(n.getValue());

        var output = sampleStruct.get("output");
        assertEquals(TypeDef.TYPE_DEF_NESTED_STRUCT, output.getValueType());
        assertTrue(output.getValue() instanceof BStructObj);

        var nestedStruct = (BStructObj) output.getValue();
        var success = nestedStruct.get("success");
        assertEquals(TypeDef.TYPE_BOOLEAN, success.getValueType());
        assertNull(success.getValue());
        var message = nestedStruct.get("message");
        assertEquals(TypeDef.TYPE_STRING, message.getValueType());
        assertNull(message.getValue());

        var coordinatesStruct = structs.get("Coordinates");
        var x = coordinatesStruct.get("x");
        assertEquals(TypeDef.TYPE_DECIMAL, x.getValueType());
        assertNull(x.getValue());

        var y = coordinatesStruct.get("y");
        assertEquals(TypeDef.TYPE_DECIMAL, y.getValueType());
        assertNull(y.getValue());
    }

}
