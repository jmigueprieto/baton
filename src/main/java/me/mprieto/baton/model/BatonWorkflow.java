package me.mprieto.baton.model;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BatonWorkflow extends BatonModel {

    private String name;

    @Builder.Default
    private Integer version = 1;

    @Builder.Default
    private String description = "";

    private BatonType input;

}


