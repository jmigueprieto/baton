package me.mprieto.baton.model;

import lombok.Getter;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

@Getter
public abstract class BatonModel<T extends Nameable, C extends ParserRuleContext> {

    private final String name;

    private final C ctx;

    private final Map<String, T> properties = new LinkedHashMap<>();

    public BatonModel(C ctx, String name) {
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
