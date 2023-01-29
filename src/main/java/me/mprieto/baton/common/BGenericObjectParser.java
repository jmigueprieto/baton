package me.mprieto.baton.common;

import lombok.RequiredArgsConstructor;
import me.mprieto.baton.common.exceptions.InvalidTypeException;
import me.mprieto.baton.common.model.BObj;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonLexer;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BGenericObjectParser {


    public BObj parse(String name, Baton.ObjectContext objectCtx) {
        var obj = new BObj(objectCtx, name);
        var keyValuePairs = objectCtx.keyValuePair();

        return loadProperties(obj, keyValuePairs);
    }

    public BObj parse(String name, Baton.ParametersContext parametersContext) {
        var obj = new BObj(parametersContext, name);
        var keyValuePairs = parametersContext.keyValuePair();

        return loadProperties(obj, keyValuePairs);
    }

    public BObj loadProperties(BObj obj, List<Baton.KeyValuePairContext> keyValuePairs) {
        for (Baton.KeyValuePairContext ctx : keyValuePairs) {
            var key = ctx.key().getText();
            var value = ctx.value();
            var property = BObj.Property.builder()
                    .name(key)
                    .valueType(getType(value))
                    .value(toObject(value))
                    .ctx(ctx)
                    .build();
            obj.add(property);
        }

        return obj;
    }

    private Object toObject(Baton.ValueContext ctx) {
        if (ctx.type() != null) {
            return Helpers.toTypeDef(ctx.type().getStart().getType());
        } else if (ctx.identifier() != null) {
            return ctx.identifier().getText();
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

    private BObj.ValueType getType(Baton.ValueContext value) {
        if (value.type() != null) {
            return BObj.ValueType.TYPE_DEF;
        } else if (value.identifier() != null) {
            return BObj.ValueType.IDENTIFIER;
        } else if (value.literal() != null) {
            var tokenType = value.literal().getStart().getType();
            switch (tokenType) {
                case BatonLexer.LITERAL_STRING:
                    return BObj.ValueType.LITERAL_STRING;
                case BatonLexer.LITERAL_BOOL:
                    return BObj.ValueType.LITERAL_BOOL;
                case BatonLexer.LITERAL_DECIMAL:
                    return BObj.ValueType.LITERAL_DECIMAL;
                case BatonLexer.LITERAL_INTEGER:
                    return BObj.ValueType.LITERAL_INTEGER;
                case BatonLexer.LITERAL_NULL:
                    return BObj.ValueType.LITERAL_NULL;
            }
        } else if (value.array() != null) {
            return BObj.ValueType.ARRAY;
        } else if (value.object() != null) {
            return BObj.ValueType.OBJECT;
        }

        throw new InvalidTypeException();
    }
}
