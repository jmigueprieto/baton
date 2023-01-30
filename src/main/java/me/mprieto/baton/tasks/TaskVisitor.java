package me.mprieto.baton.tasks;

import me.mprieto.baton.common.BObjParser;
import me.mprieto.baton.common.exceptions.DuplicateException;
import me.mprieto.baton.common.exceptions.UnknownTypeException;
import me.mprieto.baton.common.model.BObj;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonBaseVisitor;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.HashMap;
import java.util.Map;

public class TaskVisitor extends BatonBaseVisitor<Map<String, BObj>> {

    private final Map<String, BObj> tasks = new HashMap<>();

    private final BObjParser objectParser = new BObjParser();

    private final Map<String, BStructObj> structs;

    public TaskVisitor(Map<String, BStructObj> structs) {
        this.structs = structs;
    }

    @Override
    public Map<String, BObj> visitBatonUnit(Baton.BatonUnitContext ctx) {
        for (Baton.TaskDeclarationContext decl : ctx.taskDeclaration()) {
            var name = decl.IDENTIFIER().getText();
            if (tasks.containsKey(name)) {
                int line = decl.getStart().getLine();
                throw new DuplicateException("task " + name + " already exists. Line: " + line);
            }
            var obj = objectParser.parse(decl.object());
            typeCheck(obj);
            tasks.put(name, obj);
        }

        return tasks;
    }

    private void typeCheck(BObj obj) {
        var properties = obj.list();
        for (var prop : properties) {
            if (prop.getValueType() == BObj.ValueType.IDENTIFIER) {
                var identifier = (String) prop.getValue();
                if (!structs.containsKey(identifier)) {
                    //TODO improve error handling and messaging
                    int line = prop.getCtx().getStart().getLine();
                    throw new UnknownTypeException("Unknown type " + identifier + " in line " + line);
                }
            } else if (prop.getValueType() == BObj.ValueType.OBJECT) {
                typeCheck((BObj) prop.getValue());
            }
        }
    }
}
