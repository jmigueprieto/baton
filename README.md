# Baton

> _This is still a Work In Progress so even though an initial grammar has been defined, the translator
is not functional yet but early feedback will be much appreciated._


Baton is a language designed to simplify the process of creating and maintaining workflows 
for developers using Netflix Conductor. 

Baton intends to offer intuitive language constructs, like `IF statements` (WIP) and `WHILE loops` (WIP), which 
will result familiar to any developer. While Netflix Conductor does have built-in tasks for these operations, 
its JSON DSL can be somewhat challenging to read and understand; after all JSON is a data language and was 
not intended to support things like control structures or type checking.

## Hello World!

This Baton Workflow
```
// Task declarations provide type safety when using it in the workflow
task GreetingTask {
    input: { name: String },
    output: { message: String },
    description: "Give me name and I'll say hi"
}

workflow HelloWorld (
    input : { name: String },
    description: "Hello Baton!",
    version : 1
) : { message : String } {
    def greetingTask = execute GreetingTask(input : { name: input.name })
    return { message: greetingTask.output.message }
}
```

should translate to this Conductor Workflow:

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
  "timeoutSeconds": 0
}
```

## Type safety

Baton includes built-in (optional) type checking to ensure that your workflows are correct.
For example, if you try to pass a String to a task that expects an Integer,
Baton will raise an error. This helps to catch errors early,
before they cause problems in your running workflow.

However, keep in mind that when executing in Conductor these types won't be enforced. Think of this as type-erasure.

## Code generators

Last but not least when defining Tasks in Baton these definitions could be used to generate 
project templates containing workers with their respective inputs and outputs in languages like Java, Python, C#, etc. (WIP).


