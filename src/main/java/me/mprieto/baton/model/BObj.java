package me.mprieto.baton.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;

public class BObj extends BatonObject<BObj.Property> {

    @RequiredArgsConstructor
    @Getter
    @Builder
    public static class Property implements BaseProperty {
        private final String name;
        private final BType type;
        private final Object value;
        private final ParserRuleContext ctx;

        public Integer asInteger() {
            return (Integer) value;
        }

        public String asString() {
            return (String) value;
        }

        public Double asDouble() {
            return (Double) value;
        }

        public Boolean asBoolean() {
            return (Boolean) value;
        }

        public BObj asBObj() {
            return (BObj) value;
        }
    }

    public BObj(ParserRuleContext ctx) {
        super(ctx);
    }
}
