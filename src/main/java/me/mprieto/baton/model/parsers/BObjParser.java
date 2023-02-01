package me.mprieto.baton.model.parsers;

import lombok.RequiredArgsConstructor;
import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.model.BObj;
import me.mprieto.baton.model.BType;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BObjParser {

    public BObj parse(Baton.ObjectContext objectContext) {
        var obj = new BObj(objectContext);
        var keyValuePairs = objectContext.keyValuePair();
        return loadProperties(obj, keyValuePairs);
    }

    public BObj parse(Baton.ExecParamsContext execParams) {
        var obj = new BObj(execParams);
        var keyValuePairs = execParams.keyValuePair();
        return loadProperties(obj, keyValuePairs);
    }

    private BObj loadProperties(BObj obj, List<Baton.KeyValuePairContext> keyValuePairs) {
        if (keyValuePairs != null) {
            for (Baton.KeyValuePairContext ctx : keyValuePairs) {
                obj.add(parseProperty(ctx));
            }
        }

        return obj;
    }

    BObj.Property parseProperty(Baton.KeyValuePairContext ctx) {
        var key = ctx.key().getText();
        var value = ctx.value();
        return BObj.Property.builder()
                .name(key)
                .type(getType(value))
                .value(toObject(value))
                .ctx(ctx)
                .build();
    }

    private Object toObject(Baton.ValueContext ctx) {
        if (ctx.identifier() != null) {
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
                    return Long.parseLong(text);
                case BatonLexer.LITERAL_NULL:
                    return null;
            }
        } else if (ctx.array() != null) {
            return parseArray(ctx.array());
        } else if (ctx.object() != null) {
            return parse(ctx.object());
        }

        return null;
    }

    private List<Object> parseArray(Baton.ArrayContext ctx) {
        return ctx.value()
                .stream()
                .map(this::toObject)
                .collect(Collectors.toList());
    }

    private BType getType(Baton.ValueContext value) {
        if (value.identifier() != null) {
            return BType.IDENTIFIER;
        } else if (value.literal() != null) {
            var tokenType = value.literal().getStart().getType();
            switch (tokenType) {
                case BatonLexer.LITERAL_STRING:
                    return BType.STRING;
                case BatonLexer.LITERAL_BOOL:
                    return BType.BOOLEAN;
                case BatonLexer.LITERAL_DECIMAL:
                    return BType.DECIMAL;
                case BatonLexer.LITERAL_INTEGER:
                    return BType.INTEGER;
                case BatonLexer.LITERAL_NULL:
                    return BType.NULL;
            }
        } else if (value.array() != null) {
            return BType.ARRAY;
        } else if (value.object() != null) {
            return BType.OBJECT;
        }

        throw new InvalidTypeException();
    }
}
