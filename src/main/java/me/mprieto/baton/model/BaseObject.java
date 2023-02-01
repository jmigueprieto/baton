package me.mprieto.baton.model;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

public abstract class BaseObject<T extends BaseObject.BaseProperty> {

    public interface BaseProperty {
        String getName();
    }


    protected final Map<String, T> properties = new LinkedHashMap<>();
    protected final ParserRuleContext ctx;

    public BaseObject(ParserRuleContext ctx) {
        this.ctx = ctx;
    }

    public ParserRuleContext getCtx() {
        return ctx;
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
