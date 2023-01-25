package me.mprieto.baton.visitors;

import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.BatonObjectProperty;
import me.mprieto.baton.model.BatonObjectType;
import me.mprieto.baton.model.exceptions.DuplicateException;
import me.mprieto.baton.model.struct.BatonStruct;
import me.mprieto.baton.model.task.BatonTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskVisitor extends BatonBaseVisitor<Map<String, BatonTask>> {

    private final Map<String, BatonTask> tasks = new HashMap<>();

    private final Map<String, BatonStruct> structs;

    public TaskVisitor(Map<String, BatonStruct> structs) {
        this.structs = structs;
    }


    @Override
    public Map<String, BatonTask> visitBatonUnit(BatonParser.BatonUnitContext ctx) {
        ctx.taskDeclaration().forEach(it -> {
            var name = it.IDENTIFIER().getText();
            if (tasks.containsKey(name)) {
                int line = ctx.getStart().getLine();
                throw new DuplicateException("struct " + name + " already exists. Line: " + line);
            }

            tasks.put(name, parseTaskDeclaration(name, it.object()));
        });

        return tasks;
    }

    private BatonTask parseTaskDeclaration(String name, BatonParser.ObjectContext objectCtx) {
        var task = new BatonTask(objectCtx, name);
        var keyValuePairs = objectCtx.keyValuePair();

        for (BatonParser.KeyValuePairContext ctx : keyValuePairs) {
            var key = ctx.key().getText();
            var type = getType(ctx);
            var value = getValue(ctx);
            task.add(BatonObjectProperty.builder()
                    .name(key)
                    .type(type)
                    .value(value)
                    .build());
        }

        return task;
    }

    private Object getValue(BatonParser.KeyValuePairContext ctx) {
        return null;
    }

    private BatonObjectType getType(BatonParser.KeyValuePairContext ctx) {
        return null;
    }
}
