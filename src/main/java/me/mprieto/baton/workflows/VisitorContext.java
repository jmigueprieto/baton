package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import lombok.RequiredArgsConstructor;
import me.mprieto.baton.model.BMetadataParams;
import me.mprieto.baton.model.BStruct;
import me.mprieto.baton.model.BVar;
import me.mprieto.baton.model.parsers.BMetadataParamsParser;
import me.mprieto.baton.model.parsers.BObjParser;
import me.mprieto.baton.model.parsers.BStructParser;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
class VisitorContext {
    private final BObjParser objectParser = new BObjParser();
    private final BStructParser structParser = new BStructParser();
    private final BMetadataParamsParser metadataParamsParser = new BMetadataParamsParser();
    private final Map<String, BVar> variables = new HashMap<>();
    private final Map<String, BMetadataParams> taskDefinitions;
    private final Map<String, BStruct> structDefinitions;

    private final WorkflowDef workflowDef = new WorkflowDef();

    void addVar(String name, BVar var) {
        variables.put(name, var);
    }

    BVar getVar(String name) {
        return variables.get(name);
    }

    boolean containsVar(String name) {
        return variables.containsKey(name);
    }

    void addStruct(String name, BStruct struct) {
        structDefinitions.put(name, struct);
    }

    BStruct getStruct(String name) {
        return structDefinitions.get(name);
    }

    boolean containsStruct(String name) {
        return structDefinitions.containsKey(name);
    }

    BMetadataParams getTaskDef(String name) {
        return taskDefinitions.get(name);
    }

    boolean containsTaskDef(String name) {
        return taskDefinitions.containsKey(name);
    }

    BObjParser objParser() {
        return this.objectParser;
    }

    BStructParser structParser() {
        return this.structParser;
    }

    BMetadataParamsParser metadataParamsParser() {
        return this.metadataParamsParser;
    }

    WorkflowDef workflowDef() {
        return this.workflowDef;
    }
}
