package me.mprieto.baton.model.struct;

import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.BatonModel;

public class BatonStruct extends BatonModel<BatonStructProperty, BatonParser.StructDefContext> {


    public BatonStruct(BatonParser.StructDefContext ctx, String name) {
        super(ctx, name);
    }

}
