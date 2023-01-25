package me.mprieto.baton.model.workflow;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BWorkflow {

    private String name;

    @Builder.Default
    private Integer version = 1;

    @Builder.Default
    private String description = "";

}


