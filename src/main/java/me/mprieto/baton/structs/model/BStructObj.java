package me.mprieto.baton.structs.model;

import lombok.Builder;
import me.mprieto.baton.common.model.BObject;
import me.mprieto.baton.common.model.TypeDef;
import me.mprieto.baton.grammar.Baton;

public class BStructObj extends BObject<BStructObj.Property, Baton.StructDefContext> {

    public static class Property extends BProperty<TypeDef> {
        @Builder
        public Property(String name, TypeDef valueType, Object value) {
            super(name, valueType, value);
        }
    }

    public BStructObj(Baton.StructDefContext ctx, String name) {
        super(ctx, name);
    }

}
