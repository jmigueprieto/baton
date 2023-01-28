package me.mprieto.baton.tree;

import lombok.RequiredArgsConstructor;
import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.exceptions.DuplicateException;
import me.mprieto.baton.model.exceptions.InvalidTypeException;
import me.mprieto.baton.model.BStructObj;
import me.mprieto.baton.model.BGenericObj;
import me.mprieto.baton.model.exceptions.UnknownTypeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TaskVisitor extends BatonBaseVisitor<Map<String, BGenericObj>> {

    private final Map<String, BGenericObj> tasks = new HashMap<>();

    private final Map<String, BStructObj> structs;

    @Override
    public Map<String, BGenericObj> visitBatonUnit(BatonParser.BatonUnitContext ctx) {
        for (BatonParser.TaskDeclarationContext decl : ctx.taskDeclaration()) {
            var name = decl.IDENTIFIER().getText();
            if (tasks.containsKey(name)) {
                int line = decl.getStart().getLine();
                throw new DuplicateException("task " + name + " already exists. Line: " + line);
            }

            tasks.put(name, parseObject(name, decl.object()));
        }

        return tasks;
    }

    private BGenericObj parseObject(String name, BatonParser.ObjectContext objectCtx) {
        var obj = new BGenericObj(objectCtx, name);
        var keyValuePairs = objectCtx.keyValuePair();

        for (BatonParser.KeyValuePairContext ctx : keyValuePairs) {
            var key = ctx.key().getText();
            var value = ctx.value();
            var property = BGenericObj.Property.builder()
                    .name(key)
                    .valueType(getType(value))
                    .value(getValue(value))
                    .build();
            obj.add(property);
        }

        return obj;
    }

    private List<Object> parseArray(BatonParser.ArrayContext ctx) {
        return ctx.value()
                .stream()
                .map(this::getValue)
                .collect(Collectors.toList());
    }

    private Object getValue(BatonParser.ValueContext ctx) {
        if (ctx.type() != null) {
            return Utils.toTypeDef(ctx.type().getStart().getType());
        } else if (ctx.IDENTIFIER() != null) {
            var identifier = ctx.IDENTIFIER().getText();
            if (!structs.containsKey(identifier)) {
                //TODO improve error handling and messaging
                int line = ctx.getStart().getLine();
                throw new UnknownTypeException("Unknown type " + identifier + " in line " + line);
            }
            return ctx.IDENTIFIER().getText();
        } else if (ctx.literal() != null) {
            var tokenType = ctx.literal().getStart().getType();
            var text = ctx.literal().getText();
            switch (tokenType) {
                case BatonLexer.LITERAL_STRING:
                    return text;
                case BatonLexer.LITERAL_BOOL:
                    return Boolean.valueOf(text);
                case BatonLexer.LITERAL_DECIMAL:
                    return Double.parseDouble(text);
                case BatonLexer.LITERAL_INTEGER:
                    return Integer.parseInt(text);
                case BatonLexer.LITERAL_NULL:
                    return null;
            }
        } else if (ctx.array() != null) {
            return parseArray(ctx.array());
        } else if (ctx.object() != null) {
            return parseObject("_", ctx.object());
        }

        return null;
    }

    private BGenericObj.ValueType getType(BatonParser.ValueContext value) {
        if (value.type() != null) {
            return BGenericObj.ValueType.TYPE_DEF;
        } else if (value.IDENTIFIER() != null) {
            return BGenericObj.ValueType.IDENTIFIER;
        } else if (value.literal() != null) {
            var tokenType = value.literal().getStart().getType();
            switch (tokenType) {
                case BatonLexer.LITERAL_STRING:
                    return BGenericObj.ValueType.LITERAL_STRING;
                case BatonLexer.LITERAL_BOOL:
                    return BGenericObj.ValueType.LITERAL_BOOL;
                case BatonLexer.LITERAL_DECIMAL:
                    return BGenericObj.ValueType.LITERAL_DECIMAL;
                case BatonLexer.LITERAL_INTEGER:
                    return BGenericObj.ValueType.LITERAL_INTEGER;
                case BatonLexer.LITERAL_NULL:
                    return BGenericObj.ValueType.LITERAL_NULL;
            }
        } else if (value.array() != null) {
            return BGenericObj.ValueType.ARRAY;
        } else if (value.object() != null) {
            return BGenericObj.ValueType.OBJECT;
        }

        throw new InvalidTypeException();
    }
}
