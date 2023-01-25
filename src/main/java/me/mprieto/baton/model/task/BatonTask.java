package me.mprieto.baton.model.task;

import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.BatonModel;
import me.mprieto.baton.model.BatonObjectProperty;

public class BatonTask extends BatonModel<BatonObjectProperty, BatonParser.ObjectContext> {

    public BatonTask(BatonParser.ObjectContext ctx, String name) {
        super(ctx, name);
    }

}
