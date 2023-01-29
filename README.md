# Baton

Baton is a workflow language designed to simplify the process of creating and maintaining workflows 
for developers using Netflix Conductor. 

Baton offers intuitive language constructs, like `IF statements` (WIP) and `WHILE loops` (WIP), which will result familiar 
to any developer. While Netflix Conductor does have built-in tasks for these operations, 
its JSON DSL can make it somewhat challenging to read and understand; 
after all JSON is a data language and was not intended to support things like control structures 
or type checking.

## Hello World!

This Baton Workflow
```
// This task declaration provides type safety when using it in the workflow
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

translates to this Conductor Workflow:

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

However, keep in mind that when executing in Conductor these types won't be enforced. Think of it as type-erasure.

## Code generations

Last but not least when defining metadata (workflows and tasks) in Baton these definitions could be used to generate 
project templates in other languages like Java, Python, C#, etc. (WIP). 
These project templates will contain workers with the expected input and output.


