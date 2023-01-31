package me.mprieto.baton.model.parsers;

import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.model.BStruct;
import me.mprieto.baton.model.BType;

public class BStructParser {

    public BStruct parse(Baton.StructDefContext structCtx) {
        var struct = new BStruct(structCtx);
        var keyTypePairs = structCtx.keyTypePair();
        if (keyTypePairs != null) {
            for (Baton.KeyTypePairContext ctx : keyTypePairs) {
                struct.add(parseProperty(ctx));
            }
        }

        return struct;
    }

    BStruct.Property parseProperty(Baton.KeyTypePairContext ctx) {
        var key = ctx.key().getText();
        var type = getType(ctx);
        if (type == BType.OBJECT) {
            return BStruct.Property.builder()
                    .name(key)
                    .type(type)
                    .struct(parse(ctx.structDef()))
                    .build();
        } else if (type == BType.IDENTIFIER) {
            return BStruct.Property.builder()
                    .name(key)
                    .type(type)
                    .identifier(ctx.IDENTIFIER().getText())
                    .build();
        } else {
            return BStruct.Property.builder()
                    .name(key)
                    .type(type)
                    .build();
        }
    }

    private BType getType(Baton.KeyTypePairContext ctx) {
        if (ctx.type() != null) {
            var typeDef = toTypeDef(ctx.type().getStart().getType());
            if (typeDef != null) {
                return typeDef;
            }
        } else if (ctx.IDENTIFIER() != null) {
            return BType.IDENTIFIER;
        } else if (ctx.structDef() != null) {
            return BType.OBJECT;
        }

        //TODO improve error handling
        throw new InvalidTypeException();
    }

    private BType toTypeDef(int tokenType) {
        switch (tokenType) {
            case BatonLexer.TYPE_STRING:
                return BType.STRING;
            case BatonLexer.TYPE_BOOLEAN:
                return BType.BOOLEAN;
            case BatonLexer.TYPE_INTEGER:
                return BType.INTEGER;
            case BatonLexer.TYPE_DECIMAL:
                return BType.DECIMAL;
        }

        return null;
    }
}
