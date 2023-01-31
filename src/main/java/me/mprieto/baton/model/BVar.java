package me.mprieto.baton.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.ParserRuleContext;

@Getter
@Setter
@AllArgsConstructor
public class BVar {
    private ParserRuleContext ctx;
    private BType type;
    // set to the Struct definition of the Object if type == BType.Object
    private BStruct struct;
}
