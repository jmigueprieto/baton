package me.mprieto.baton;

import com.netflix.conductor.common.metadata.tasks.TaskDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/**
 * GraalVM Native Image configuration for reflection.
 * Registers classes that Jackson serializes/deserializes via reflection.
 */
public class NativeImageConfiguration implements Feature {

    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        // Register Conductor workflow model classes for reflection
        registerForReflection(WorkflowDef.class);
        registerForReflection(WorkflowTask.class);
        registerForReflection(TaskDef.class);

        // Register common Java types that might be used in workflows
        registerForReflection(java.util.HashMap.class);
        registerForReflection(java.util.ArrayList.class);
        registerForReflection(java.util.LinkedHashMap.class);
    }

    private void registerForReflection(Class<?> clazz) {
        RuntimeReflection.register(clazz);
        RuntimeReflection.register(clazz.getDeclaredConstructors());
        RuntimeReflection.register(clazz.getDeclaredMethods());
        RuntimeReflection.register(clazz.getDeclaredFields());
    }
}
