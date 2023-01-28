package me.mprieto.baton.common;

import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.common.model.TypeDef;


public class Helpers {

    public static TypeDef toTypeDef(int tokenType) {
        switch (tokenType) {
            case BatonLexer.TYPE_STRING:
                return TypeDef.TYPE_STRING;
            case BatonLexer.TYPE_BOOLEAN:
                return TypeDef.TYPE_BOOLEAN;
            case BatonLexer.TYPE_INTEGER:
                return TypeDef.TYPE_INTEGER;
            case BatonLexer.TYPE_DECIMAL:
                return TypeDef.TYPE_DECIMAL;
        }

        return null;
    }

}
