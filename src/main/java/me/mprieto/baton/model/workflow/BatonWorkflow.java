package me.mprieto.baton.model.workflow;


import lombok.Builder;
import lombok.Getter;
import me.mprieto.baton.model.Nameable;
import me.mprieto.baton.model.struct.BatonStructType;

@Builder
@Getter
public class BatonWorkflow implements Nameable {

    private String name;

    @Builder.Default
    private Integer version = 1;

    @Builder.Default
    private String description = "";

    private BatonStructType input;

}


