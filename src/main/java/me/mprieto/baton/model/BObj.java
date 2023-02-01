package me.mprieto.baton.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.mprieto.baton.exceptions.InvalidTypeException;
import org.antlr.v4.runtime.ParserRuleContext;

public class BObj extends BaseObject<BObj.Property> {

    @RequiredArgsConstructor
    @Getter
    @Builder
    public static class Property implements BaseProperty {
        private final String name;
        private final BType type;
        private final Object value;
        private final ParserRuleContext ctx;

        public Long asLong() {
            if (type != BType.INTEGER) {
                throw new InvalidTypeException(invalidTypeExceptionMessage(Long.class));
            }

            return (Long) value;
        }

        public Integer asInteger() {
            if (type != BType.INTEGER) {
                throw new InvalidTypeException(invalidTypeExceptionMessage(Integer.class));
            }

            return ((Long) value).intValue();
        }

        public String asString() {
            if (type != BType.STRING && type != BType.IDENTIFIER) {
                throw new InvalidTypeException(invalidTypeExceptionMessage(String.class));
            }

            return (String) value;
        }

        public Double asDouble() {
            if (type != BType.DECIMAL) {
                throw new InvalidTypeException(invalidTypeExceptionMessage(Double.class));
            }

            return (Double) value;
        }

        public Boolean asBoolean() {
            if (type != BType.BOOLEAN) {
                throw new InvalidTypeException(invalidTypeExceptionMessage(Boolean.class));
            }

            return (Boolean) value;
        }

        public BObj asBObj() {
            if (type != BType.OBJECT) {
                throw new InvalidTypeException(invalidTypeExceptionMessage(BObj.class));
            }

            return (BObj) value;
        }

        private String invalidTypeExceptionMessage(Class<?> clazz) {
            return String.format("Property '%s' has Baton Type %s. Cannot convert to Java's %s.",
                    name, type,
                    clazz.getName());
        }
    }

    public BObj(ParserRuleContext ctx) {
        super(ctx);
    }


}
