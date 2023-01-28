package me.mprieto.baton.tasks;

import me.mprieto.baton.common.BGenericObjectParser;
import me.mprieto.baton.common.exceptions.DuplicateException;
import me.mprieto.baton.common.model.BGenericObj;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.HashMap;
import java.util.Map;

public class TaskVisitor extends BatonBaseVisitor<Map<String, BGenericObj>> {

    private final Map<String, BGenericObj> tasks = new HashMap<>();

    private final BGenericObjectParser objectParser;

    public TaskVisitor(Map<String, BStructObj> structs) {
        this.objectParser = new BGenericObjectParser(structs);
    }

    @Override
    public Map<String, BGenericObj> visitBatonUnit(Baton.BatonUnitContext ctx) {
        for (Baton.TaskDeclarationContext decl : ctx.taskDeclaration()) {
            var name = decl.IDENTIFIER().getText();
            if (tasks.containsKey(name)) {
                int line = decl.getStart().getLine();
                throw new DuplicateException("task " + name + " already exists. Line: " + line);
            }

            tasks.put(name, objectParser.parse(name, decl.object()));
        }

        return tasks;
    }
}
