package me.mprieto.baton.model.struct;

import lombok.Builder;
import lombok.Getter;
import me.mprieto.baton.model.Nameable;

@Builder
@Getter
public class BatonStructProperty implements Nameable {
    private final String name;
    private final BatonStructType type;
    private final Object value;
}
