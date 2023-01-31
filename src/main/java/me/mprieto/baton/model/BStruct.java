package me.mprieto.baton.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.mprieto.baton.grammar.Baton;
import org.antlr.v4.runtime.ParserRuleContext;

public class BStruct extends BatonObject<BStruct.Property> {

    @RequiredArgsConstructor
    @Getter
    @Builder
    public static class Property implements BaseProperty {
        private final String name;
        private final BType type;
        private final String identifier;
        private final BStruct struct;
        private final ParserRuleContext ctx;
    }

    public BStruct(Baton.StructDefContext ctx) {
        super(ctx);
    }

}
