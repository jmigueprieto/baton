# Baton

> _This is still a Work In Progress so even though an initial grammar has been defined, the translator
is not functional yet but early feedback will be much appreciated._

Baton is a language designed to simplify the process of creating and maintaining workflows 
for developers using Netflix Conductor. 

Where does the name come from? a baton is a light, thin stick used by a conductor to direct an orchestra.

## Hello World!

This Baton Workflow
```
// Task declarations provide type safety
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

translates to this Conductor Workflow

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
This might not be very impressive, but it's a start.

To try it out you can run:

```shell
./gradlew build
java -jar build/libs/baton-1.0-SNAPSHOT.jar -f samples/sample0.baton
```

## Parse Tree inspector

You can take a look at the parse tree with Antlr's inspector GUI. This is very useful if there's a syntax error
because at the moment the error handler strategy (`BailErrorStrategy`) just terminates the parsing in case of an error. 
Improving the error handling and messaging is in the TODO list.


```shell
./gradlew build
java -jar build/libs/baton-1.0-SNAPSHOT.jar -f samples/sample0.baton
```

![alt text](docs/images/parse-tree-sample0.png)

## Language constructs (WIP)

Baton intends to offer intuitive language constructs, like `IF statements` (WIP) and `WHILE loops` (WIP), which
will result familiar to any developer. While Netflix Conductor does have built-in tasks for these operations,
its JSON DSL can be somewhat challenging to read and understand; after all JSON is a data language and was
not intended to support things like control structures or type checking.

## Type safety (WIP)

Baton includes built-in (optional) type checking to ensure that your workflows are correct.
For example, if you try to pass a String to a task that expects an Integer,
Baton will raise an error. This helps to catch errors early,
before they cause problems in your running workflows.

However, keep in mind that when executing in Conductor these types won't be enforced. Think of this as type-erasure.

## Code generators (WIP)

Last but not least when defining Tasks in Baton these definitions could be used to generate 
project templates containing workers with their respective inputs and outputs in languages like Java, Python, C#, etc. (WIP).


