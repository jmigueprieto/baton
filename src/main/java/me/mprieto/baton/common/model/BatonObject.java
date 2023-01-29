package me.mprieto.baton.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

@Getter
public abstract class BatonObject<T extends BatonObject.BProperty<?>> {

    @AllArgsConstructor
    @Getter
    public static abstract class BProperty<T> {
        private final String name;
        private final T valueType;
        private final Object value;
        private final ParserRuleContext ctx;
    }

    private final String name;

    private final ParserRuleContext ctx;

    private final Map<String, T> properties = new LinkedHashMap<>();

    public BatonObject(ParserRuleContext ctx, String name) {
        this.name = name;
        this.ctx = ctx;
    }

    public void add(T property) {
        if (properties.containsKey(property.getName())) {
            throw new DuplicateFormatFlagsException(String.format("Field %s is duplicated", property.getName()));
        }

        properties.put(property.getName(), property);
    }

    public T get(String name) {
        return properties.get(name);
    }

    public Collection<T> list() {
        return Collections.unmodifiableCollection(properties.values());
    }
}
