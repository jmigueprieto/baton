package me.mprieto.baton.tasks;

import me.mprieto.baton.exceptions.DuplicateException;
import me.mprieto.baton.exceptions.UnknownTypeException;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.model.*;
import me.mprieto.baton.model.parsers.BMetadataParamsParser;

import java.util.HashMap;
import java.util.Map;

public class TaskVisitor extends BatonBaseVisitor<Map<String, BMetadataParams>> {

    private final BMetadataParamsParser metadataParamsParser = new BMetadataParamsParser();

    private final Map<String, BMetadataParams> taskDefinitions = new HashMap<>();

    private final Map<String, BStruct> structDefinitions;

    public TaskVisitor(Map<String, BStruct> structs) {
        this.structDefinitions = structs;
    }

    @Override
    public Map<String, BMetadataParams> visitBatonUnit(Baton.BatonUnitContext ctx) {
        for (Baton.TaskDeclarationContext decl : ctx.taskDeclaration()) {
            var name = decl.IDENTIFIER().getText();
            if (taskDefinitions.containsKey(name)) {
                int line = decl.getStart().getLine();
                throw new DuplicateException("task " + name + " already exists. Line: " + line);
            }
            var params = metadataParamsParser.parse(decl.taskParams().metadataParams());
            typeCheck(params);
            taskDefinitions.put(name, params);
        }

        return taskDefinitions;
    }

    private void typeCheck(BMetadataParams params) {
        typeCheck(params.getInput());
        typeCheck(params.getOutput());
    }

    private void typeCheck(BStruct.Property property) {
        if (property == null) {
            return;
        }

        if (property.getType() == BType.IDENTIFIER) {
            var identifier = property.getIdentifier();
            if (!structDefinitions.containsKey(identifier)) {
                //TODO improve error handling and messaging
                int line = property.getCtx().getStart().getLine();
                throw new UnknownTypeException("Unknown type " + identifier + " in line " + line);
            }
        } else if (property.getType() == BType.OBJECT) {
            typeCheck(property.getStruct());
        }
    }

    private void typeCheck(BStruct struct) {
        struct.list().forEach(this::typeCheck);
    }

}
