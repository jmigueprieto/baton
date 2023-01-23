package me.mprieto.baton.model;

import lombok.Builder;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class BatonTask extends BatonModel {
    private final String name;
    private Map<String, BatonObjectProperty> properties = new LinkedHashMap<>();

    @Builder
    public BatonTask(String name) {
        this.name = name;
    }
}
