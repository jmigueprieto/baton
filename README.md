# Baton

Baton is a workflow language. **It's a Work in Progress**.

 The initial goal of the project is to translate Baton Workflows to Conductor JSON DSL, e.g.:

This Baton Workflow
```
workflow HelloWorld (
    input : { name: String },
    description: "Hello Baton!",
    version : 1
) : { data : String, "fact Length" : Integer } {
    def greetingTask = execute GreetingTask(input : { name: this.name })
    return greetingTask.output.message
}
```

will output this Conductor Workflow:

```json
{
  "name": "HelloWorld",
  "description": "Hello Baton!",
  "version": 1,
  "tasks": [
    {
      "name": "greetingTask",
      "taskReferenceName": "greetingTask",
      "inputParameters": {
        "name": "${workflow.input.name}"
      },
      "type": "SIMPLE",
      "startDelay": 0,
      "optional": false,
      "asyncComplete": false
    }
  ],
  "inputParameters": [],
  "outputParameters": {
    "message": "${greetingTask.output.message}"
  },
  "schemaVersion": 2,
  "restartable": true,
  "workflowStatusListenerEnabled": false,
  "timeoutPolicy": "ALERT_ONLY",
  "timeoutSeconds": 0,
  "variables": {},
  "inputTemplate": {}
}
```

## Why Baton?

The idea behind Baton is to provide a language with constructs
which feel more familiar to developers like IF statements and WHILE loops. 

JSON is a data language, defining and using control structures may be a bit tricky (SEE: https://www.instaclustr.com/blog/workflow-comparison-uber-cadence-vs-netflix-conductor/) Baton aims at improving
the readability of the flow for devs.

Another goal is to provide type safety when defining the workflow. But, keep in mind that
when executing in Conductor these types won't be enforced. Think of it as type-erasure.

Last but not least when defining workflows and tasks in Baton these definitions could be used to generate 
project templates in other languages like Java, Python, C#, etc. (WIP). These project templates will contain workers with the expected input and output.


