package me.mprieto.baton.model.parsers;

import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.model.BMetadataParams;
import me.mprieto.baton.model.BObj;
import me.mprieto.baton.model.BStruct;
import me.mprieto.baton.model.BType;

public class BMetadataParamsParser {

    private final BObjParser objParser = new BObjParser();
    private final BStructParser structParser = new BStructParser();

    public BMetadataParams parse(Baton.MetadataParamsContext metadataParamsContext) {
        return loadProperties(new BMetadataParams(metadataParamsContext), metadataParamsContext);
    }

    private BMetadataParams loadProperties(BMetadataParams obj, Baton.MetadataParamsContext metadataParamsContext) {
        if (metadataParamsContext.keyValuePair() != null) {
            var keyValuePair = metadataParamsContext.keyValuePair();
            var key = keyValuePair.key().getText();
            // This is because in the grammar
            // (keyValuePair | keyTypePair)? (COMMA metadataParams)*
            // the keyValuePair rule is resolved when there's something like { key : IDENTIFIER }
            if ("input".equals(key) || "output".equals(key)) {
                obj.add(BStruct.Property.builder()
                        .name(key)
                        .type(BType.IDENTIFIER)
                        .identifier(keyValuePair.value().getText())
                        .ctx(keyValuePair)
                        .build());
            } else {
                obj.add(objParser.parseProperty(keyValuePair));
            }
        } else if (metadataParamsContext.keyTypePair() != null) {
            obj.add(structParser.parseProperty(metadataParamsContext.keyTypePair()));
        }

        for (Baton.MetadataParamsContext ctx : metadataParamsContext.metadataParams()) {
            loadProperties(obj, ctx);
        }

        return obj;
    }
}
