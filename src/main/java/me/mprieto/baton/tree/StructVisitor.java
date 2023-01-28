package me.mprieto.baton.tree;

import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.BStructObj;
import me.mprieto.baton.model.BStructObj.TypeDef;
import me.mprieto.baton.model.exceptions.DuplicateException;
import me.mprieto.baton.model.exceptions.InvalidTypeException;
import me.mprieto.baton.model.exceptions.UnknownTypeException;

import java.util.HashMap;
import java.util.Map;

import static me.mprieto.baton.model.BStructObj.TypeDef.TYPE_DEF_NESTED_STRUCT;
import static me.mprieto.baton.model.BStructObj.TypeDef.TYPE_DEF_STRUCT;


public class StructVisitor extends BatonBaseVisitor<Map<String, BStructObj>> {

    private final Map<String, BStructObj> structs = new HashMap<>();

    @Override
    public Map<String, BStructObj> visitBatonUnit(BatonParser.BatonUnitContext ctx) {
        for (BatonParser.StructDeclarationContext decl : ctx.structDeclaration()) {
            var name = decl.IDENTIFIER().getText();
            if (structs.containsKey(name)) {
                int line = decl.getStart().getLine();
                throw new DuplicateException("struct " + name + " already exists. Line: " + line);
            }

            structs.put(name, parseStructDef(name, decl.structDef()));
        }

        structs.values().forEach(this::typeCheck);
        return structs;
    }

    private void typeCheck(BStructObj struct) {
        for (BStructObj.Property p : struct.list()) {
            var key = String.valueOf(p.getValue());
            if (p.getValueType() == TYPE_DEF_STRUCT && !structs.containsKey(key)) {
                int line = struct.getCtx().getStart().getLine();
                //TODO improve error handling and messaging
                throw new UnknownTypeException("Unknown type " + p.getValue() + " in line " + line);
            } else if (p.getValueType() == TYPE_DEF_NESTED_STRUCT) {
                typeCheck((BStructObj) p.getValue());
            }
        }
    }

    private BStructObj parseStructDef(String name, BatonParser.StructDefContext structCtx) {
        var struct = new BStructObj(structCtx, name);
        var keyValuePairs = structCtx.structKeyValuePair();

        for (BatonParser.StructKeyValuePairContext ctx : keyValuePairs) {
            var key = ctx.key().getText();
            var type = getType(ctx);
            var value = getValue(ctx);
            struct.add(BStructObj.Property.builder()
                    .name(key)
                    .valueType(type)
                    .value(value)
                    .build());
        }

        return struct;
    }

    private Object getValue(BatonParser.StructKeyValuePairContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return ctx.IDENTIFIER().getText();
        } else if (ctx.structDef() != null) {
            return parseStructDef("_", ctx.structDef());
        }

        return null;
    }

    private TypeDef getType(BatonParser.StructKeyValuePairContext ctx) {
        if (ctx.type() != null) {
            var typeDef = Utils.toTypeDef(ctx.type().getStart().getType());
            if (typeDef != null) {
                return typeDef;
            }
        } else if (ctx.IDENTIFIER() != null) {
            return TypeDef.TYPE_DEF_STRUCT;
        } else if (ctx.structDef() != null) {
            return TYPE_DEF_NESTED_STRUCT;
        }

        //TODO improve error handling
        throw new InvalidTypeException();
    }
}
