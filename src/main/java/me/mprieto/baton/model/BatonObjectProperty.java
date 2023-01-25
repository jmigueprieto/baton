package me.mprieto.baton.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BatonObjectProperty implements Nameable {
    private final String name;
    private final BatonObjectType type;
    private final Object value;
}
