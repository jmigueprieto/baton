package me.mprieto.baton.structs;

import me.mprieto.baton.exceptions.DuplicateException;
import me.mprieto.baton.exceptions.UnknownTypeException;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.model.BStruct;
import me.mprieto.baton.model.BType;
import me.mprieto.baton.model.parsers.BStructParser;

import java.util.HashMap;
import java.util.Map;

public class StructVisitor extends BatonBaseVisitor<Map<String, BStruct>> {

    private final Map<String, BStruct> structs = new HashMap<>();

    private final BStructParser structParser = new BStructParser();

    @Override
    public Map<String, BStruct> visitBatonUnit(Baton.BatonUnitContext ctx) {
        for (Baton.StructDeclarationContext decl : ctx.structDeclaration()) {
            var name = decl.IDENTIFIER().getText();
            if (structs.containsKey(name)) {
                int line = decl.getStart().getLine();
                throw new DuplicateException("struct " + name + " already exists. Line: " + line);
            }

            structs.put(name, structParser.parse(decl.structDef()));
        }

        structs.values().forEach(this::typeCheck);
        return structs;
    }

    private void typeCheck(BStruct struct) {
        for (var prop : struct.list()) {
            if (prop.getType() == BType.IDENTIFIER && !structs.containsKey(prop.getIdentifier())) {
                int line = struct.getCtx().getStart().getLine();
                //TODO improve error handling and messaging
                throw new UnknownTypeException("Unknown type " + prop.getIdentifier() + " in line " + line);
            } else if (prop.getType() == BType.OBJECT) {
                typeCheck(prop.getStruct());
            }
        }
    }
}
