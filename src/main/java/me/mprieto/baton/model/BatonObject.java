package me.mprieto.baton.model;

import lombok.Builder;
import lombok.Getter;

import java.util.*;

@Getter
public class BatonObject extends BatonModel {
    private final String name;
    //TODO what are the possible types? Struct, Task and Workflow?
    private final Map<String, BatonObjectProperty> properties = new LinkedHashMap<>();

    @Builder
    public BatonObject(String name) {
        this.name = name;
    }

    public void add(BatonObjectProperty property) {
        if (properties.containsKey(property.getName())) {
            throw new DuplicateFormatFlagsException(String.format("Field %s is duplicated", property.getName()));
        }

        properties.put(property.getName(), property);
    }

    public BatonObjectProperty get(String name) {
        return properties.get(name);
    }

    public Collection<BatonObjectProperty> list() {
        return Collections.unmodifiableCollection(properties.values());
    }
}
