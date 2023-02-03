package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import me.mprieto.baton.grammar.Baton;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class BlockVisitor extends Visitor<List<WorkflowTask>> {

    private final StatementVisitor statementVisitor;

    BlockVisitor(VisitorContext vCtx) {
        super(vCtx);
        statementVisitor = new StatementVisitor(vCtx, this);
    }

    @Override
    public List<WorkflowTask> visitBlock(Baton.BlockContext ctx) {
        if (ctx.statement() == null) {
            return List.of();
        }

        // A block is defined as '{' statement* '}'.
        // Statements either map to a Task or mutate the state of WorkflowDef in the context
        return ctx.statement().stream()
                .flatMap(it -> {
                    var tasks = statementVisitor.visit(it);
                    return tasks != null? tasks.stream() : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
