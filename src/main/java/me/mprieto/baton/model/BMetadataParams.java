package me.mprieto.baton.model;

import lombok.Getter;
import org.antlr.v4.runtime.ParserRuleContext;

@Getter
public class BMetadataParams extends BObj {

    private BStruct.Property input;
    private BStruct.Property output;

    public BMetadataParams(ParserRuleContext ctx) {
        super(ctx);
    }

    public void add(BStruct.Property property) {
        if ("input".equals(property.getName())) {
            input = property;
        } else if ("output".equals(property.getName())) {
            output = property;
        } else {
            throw new RuntimeException("Invalid Property " + property.getName());
        }
    }
}
