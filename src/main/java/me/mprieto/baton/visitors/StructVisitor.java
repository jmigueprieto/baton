package me.mprieto.baton.visitors;

import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.exceptions.DuplicateException;
import me.mprieto.baton.model.exceptions.InvalidBatonTypeException;
import me.mprieto.baton.model.exceptions.UnknownTypeException;
import me.mprieto.baton.model.struct.BatonStruct;
import me.mprieto.baton.model.struct.BatonStructProperty;
import me.mprieto.baton.model.struct.BatonStructType;

import java.util.HashMap;
import java.util.Map;

import static me.mprieto.baton.model.struct.BatonStructType.TYPE_DEF_IDENTIFIER;
import static me.mprieto.baton.model.struct.BatonStructType.TYPE_DEF_STRUCT;

public class StructVisitor extends BatonBaseVisitor<Map<String, BatonStruct>> {

    private final Map<String, BatonStruct> structs = new HashMap<>();

    @Override
    public Map<String, BatonStruct> visitBatonUnit(BatonParser.BatonUnitContext ctx) {
        ctx.structDeclaration().forEach(it -> {
            var name = it.IDENTIFIER().getText();
            if (structs.containsKey(name)) {
                int line = ctx.getStart().getLine();
                throw new DuplicateException("struct " + name + " already exists. Line: " + line);
            }

            structs.put(name, parseStructDeclaration(name, it.structDef()));
        });

        structs.values().forEach(this::typeCheck);

        return structs;
    }

    private void typeCheck(BatonStruct struct) {
        struct.list().forEach(p -> {
                    if (p.getType() == TYPE_DEF_IDENTIFIER && !structs.containsKey(String.valueOf(p.getValue()))) {
                        throw new UnknownTypeException("Unknown type " + p.getValue() + " in line " + struct.getCtx().getStart().getLine());
                    } else if (p.getType() == TYPE_DEF_STRUCT) {
                        typeCheck((BatonStruct) p.getValue());
                    }
                }
        );
    }

    private BatonStruct parseStructDeclaration(String name, BatonParser.StructDefContext structCtx) {
        var struct = new BatonStruct(structCtx, name);
        var keyValuePairs = structCtx.structKeyValuePair();

        for (BatonParser.StructKeyValuePairContext ctx : keyValuePairs) {
            var key = ctx.key().getText();
            var type = getType(ctx);
            var value = getValue(ctx);
            struct.add(BatonStructProperty.builder()
                    .name(key)
                    .type(type)
                    .value(value)
                    .build());
        }

        return struct;
    }

    private Object getValue(BatonParser.StructKeyValuePairContext ctx) {
        if (ctx.type() != null && ctx.type().IDENTIFIER() != null) {
            return ctx.type().IDENTIFIER().getText();
        } else if (ctx.structDef() != null) {
            return parseStructDeclaration("_", ctx.structDef());
        }

        return null;
    }

    private BatonStructType getType(BatonParser.StructKeyValuePairContext ctx) {
        if (ctx.type() != null) {
            switch (ctx.type().getText()) {
                case "String":
                    return BatonStructType.TYPE_DEF_STRING;
                case "Boolean":
                    return BatonStructType.TYPE_DEF_BOOLEAN;
                case "Integer":
                    return BatonStructType.TYPE_DEF_INTEGER;
                case "Decimal":
                    return BatonStructType.TYPE_DEF_DECIMAL;
                default:
                    return TYPE_DEF_IDENTIFIER;
            }
        } else if (ctx.structDef() != null) {
            return BatonStructType.TYPE_DEF_STRUCT;
        }

        throw new InvalidBatonTypeException();
    }


}
