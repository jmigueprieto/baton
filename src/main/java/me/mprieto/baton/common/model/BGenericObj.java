package me.mprieto.baton.common.model;

import lombok.Builder;
import org.antlr.v4.runtime.ParserRuleContext;

public class BGenericObj extends BObject<BGenericObj.Property, ParserRuleContext> {

    public enum ValueType {
        TYPE_DEF, // Boolean, String, Integer, Decimal

        IDENTIFIER, // The name of a custom type (struct) given by an IDENTIFIER. In the future could be a variable also.
        LITERAL_STRING,
        LITERAL_BOOL,
        LITERAL_DECIMAL,
        LITERAL_INTEGER,
        LITERAL_NULL,
        ARRAY,
        OBJECT
    }


    public static class Property extends BProperty<ValueType> {
        @Builder
        public Property(String name, ValueType valueType, Object value) {
            super(name, valueType, value);
        }
    }

    public BGenericObj(ParserRuleContext ctx, String name) {
        super(ctx, name);
    }

}
