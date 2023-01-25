package me.mprieto.baton.model;

import lombok.Builder;
import me.mprieto.baton.grammar.BatonParser;

public class BStructObj extends BObject<BStructObj.Property, BatonParser.StructDefContext> {

    public enum TypeDef {
        TYPE_BOOLEAN,
        TYPE_STRING,
        TYPE_INTEGER,
        TYPE_DECIMAL,
        TYPE_DEF_STRUCT,
        TYPE_DEF_NESTED_STRUCT
    }

    public static class Property extends BProperty<TypeDef> {
        @Builder
        public Property(String name, TypeDef valueType, Object value) {
            super(name, valueType, value);
        }
    }

    public BStructObj(BatonParser.StructDefContext ctx, String name) {
        super(ctx, name);
    }

}
