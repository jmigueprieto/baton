package me.mprieto.baton.structs.model;

import lombok.Builder;
import me.mprieto.baton.common.model.BatonObject;
import me.mprieto.baton.common.model.TypeDef;
import me.mprieto.baton.grammar.Baton;
import org.antlr.v4.runtime.ParserRuleContext;

public class BStructObj extends BatonObject<BStructObj.Property> {

    public static class Property extends BProperty<TypeDef> {
        @Builder
        public Property(String name, TypeDef valueType, Object value, ParserRuleContext ctx) {
            super(name, valueType, value, ctx);
        }
    }

    public BStructObj(Baton.StructDefContext ctx, String name) {
        super(ctx, name);
    }

}
