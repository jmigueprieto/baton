package me.mprieto.baton.listeners;

import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.*;
import me.mprieto.baton.model.exceptions.DuplicateException;
import me.mprieto.baton.model.exceptions.InvalidBatonTypeException;

import java.util.*;

public class ConductorJsonTranslator extends BatonBaseListener {

    private final Map<String, BatonObject> structs = new HashMap<>();
    private final Map<String, BatonTask> tasks = new HashMap<>();

    @Override
    public void enterStructDeclaration(BatonParser.StructDeclarationContext ctx) {
        var name = ctx.IDENTIFIER().getText();
        if (structs.containsKey(name)) {
            int line = ctx.getStart().getLine();
            throw new DuplicateException("struct " + name + " already exists. Line: " + line);
        }

        var struct = parseStructDeclaration(name, ctx.structDef().structKeyValuePair());
        structs.put(name, struct);
    }

    @Override
    public void enterTaskDeclaration(BatonParser.TaskDeclarationContext ctx) {
        var name = ctx.IDENTIFIER().getText();
        if (tasks.containsKey(name)) {
            int line = ctx.getStart().getLine();
            throw new DuplicateException("task " + name + " already exists. Line: " + line);
        }

        var task = parseTaskDeclaration(name, ctx.object());
        tasks.put(name, task);
    }

    @Override
    public void enterWorkflowDeclaration(BatonParser.WorkflowDeclarationContext ctx) {
        System.out.println("Create workflow " + ctx.IDENTIFIER().getText());
    }

    private BatonTask parseTaskDeclaration(String name, BatonParser.ObjectContext taskProperties) {
        var task = BatonTask.builder()
                .name(name)
                .build();
        return task;
    }

    private BatonObject parseStructDeclaration(String name, List<BatonParser.StructKeyValuePairContext> keyValuePairs) {
        var struct = BatonObject.builder()
                .name(name)
                .build();

        for (BatonParser.StructKeyValuePairContext ctx : keyValuePairs) {
            var key = ctx.key().getText();
            var type = getType(ctx);
            Object value = getValue(ctx);
            struct.add(BatonObjectProperty.builder()
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
            return parseStructDeclaration("_implicit_", ctx.structDef().structKeyValuePair());
        }

        return null;
    }

    private BatonType getType(BatonParser.StructKeyValuePairContext ctx) {
        if (ctx.type() != null) {
            switch (ctx.type().getText()) {
                case "String":
                    return BatonType.STRING;
                case "Boolean":
                    return BatonType.BOOLEAN;
                case "Integer":
                    return BatonType.INTEGER;
                case "Decimal":
                    return BatonType.DECIMAL;
                default:
                    return BatonType.IDENTIFIER;
            }
        } else if (ctx.structDef() != null) {
            return BatonType.STRUCT;
        }

        throw new InvalidBatonTypeException();
    }
}
