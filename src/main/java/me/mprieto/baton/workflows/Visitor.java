package me.mprieto.baton.workflows;

import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.exceptions.UnknownSymbolException;
import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.model.BObj;
import me.mprieto.baton.model.BStruct;
import me.mprieto.baton.model.BType;
import me.mprieto.baton.model.BaseObject;
import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class Visitor<T> extends BatonBaseVisitor<T> {

    protected final VisitorContext vCtx;

    Visitor(VisitorContext vCtx) {
        this.vCtx = vCtx;
    }

    static String implicitVarName(String taskType, Token ctx) {
        return taskType + "_" + ctx.getLine();
    }

    Map<String, Object> convertToMap(BObj obj) {
        return obj.list()
                .stream()
                .collect(Collectors.toMap(BaseObject.BaseProperty::getName, prop -> {
                    var type = prop.getType();
                    if (type == BType.IDENTIFIER) {
                        return convertIdentifierToRef(prop);
                    } else if (type == BType.OBJECT) {
                        return convertToMap(obj);
                    } else if (type == BType.ARRAY) {
                        //noinspection unchecked
                        return convertToList((List<BObj>) prop.getValue());
                    }

                    return prop.getValue();
                }));

    }

    String convertIdentifierToRef(BObj.Property prop) {
        var identifier = (String) prop.getValue();
        var split = identifier.split("\\.");
        var rootObj = split[0];
        if (!rootObj.equalsIgnoreCase("input")) {
            if (!vCtx.containsVar(rootObj)) {
                throw new UnknownSymbolException("Unknown variable " + rootObj +
                        " line " + prop.getCtx().getStart().getLine());
            }
            return String.format("${workflow.variables.%s}", identifier);
        } else {
            return String.format("${workflow.%s}", identifier);
        }
    }

    private List<Object> convertToList(List<BObj> list) {
        return list.stream()
                .map(this::convertToMap)
                .collect(Collectors.toList());
    }

    BStruct getMetadataIOStruct(BStruct.Property inputOrOutput) {
        if (inputOrOutput.getType() == BType.IDENTIFIER) {
            var identifier = inputOrOutput.getIdentifier();
            if (!vCtx.containsStruct(identifier)) {
                throw new InvalidTypeException("Invalid type " + identifier);
            }
            return vCtx.getStruct(identifier);
        } else if (inputOrOutput.getType() == BType.OBJECT) {
            return inputOrOutput.getStruct();
        }

        throw new InvalidTypeException("Invalid Type. Workflow and Task input/output must be a struct. " +
                "Line " + inputOrOutput.getCtx().getStart().getLine());
    }
}
