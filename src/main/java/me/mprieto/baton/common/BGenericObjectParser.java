package me.mprieto.baton.common;

import lombok.RequiredArgsConstructor;
import me.mprieto.baton.common.exceptions.InvalidTypeException;
import me.mprieto.baton.common.exceptions.UnknownTypeException;
import me.mprieto.baton.common.model.BGenericObj;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BGenericObjectParser {

    private final Map<String, BStructObj> structs;

    public BGenericObj parse(String name, Baton.ObjectContext objectCtx) {
        var obj = new BGenericObj(objectCtx, name);
        var keyValuePairs = objectCtx.keyValuePair();

        return loadProperties(obj, keyValuePairs);
    }

    public BGenericObj parse(String name, Baton.ParametersContext parametersContext) {
        var obj = new BGenericObj(parametersContext, name);
        var keyValuePairs = parametersContext.keyValuePair();

        return loadProperties(obj, keyValuePairs);
    }

    private BGenericObj loadProperties(BGenericObj obj, List<Baton.KeyValuePairContext> keyValuePairs) {
        for (Baton.KeyValuePairContext ctx : keyValuePairs) {
            var key = ctx.key().getText();
            var value = ctx.value();
            var property = BGenericObj.Property.builder()
                    .name(key)
                    .valueType(getType(value))
                    .value(toObject(value))
                    .build();
            obj.add(property);
        }

        return obj;
    }

    private Object toObject(Baton.ValueContext ctx) {
        if (ctx.type() != null) {
            return Helpers.toTypeDef(ctx.type().getStart().getType());
        } else if (ctx.IDENTIFIER() != null) {
            return ctx.IDENTIFIER().getText();
        } else if (ctx.literal() != null) {
            var tokenType = ctx.literal().getStart().getType();
            var text = ctx.literal().getText();
            switch (tokenType) {
                case BatonLexer.LITERAL_STRING:
                    return text.substring(1, text.length() - 1);
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
            return parse("_", ctx.object());
        }

        return null;
    }

    private List<Object> parseArray(Baton.ArrayContext ctx) {
        return ctx.value()
                .stream()
                .map(this::toObject)
                .collect(Collectors.toList());
    }

    private BGenericObj.ValueType getType(Baton.ValueContext value) {
        if (value.type() != null) {
            return BGenericObj.ValueType.TYPE_DEF;
        } else if (value.IDENTIFIER() != null) {
            var identifier = value.IDENTIFIER().getText();
            if (!structs.containsKey(identifier)) {
                //TODO improve error handling and messaging
                int line = value.getStart().getLine();
                throw new UnknownTypeException("Unknown type " + identifier + " in line " + line);
            }

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
