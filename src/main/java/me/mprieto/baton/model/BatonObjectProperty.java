package me.mprieto.baton.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BatonObjectProperty {
    private final String name;
    private final BatonType type;
    private final Object value;
}
