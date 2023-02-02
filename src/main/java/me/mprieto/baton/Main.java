package me.mprieto.baton;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.tasks.TaskVisitor;
import me.mprieto.baton.workflows.WorkflowVisitor;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Main {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

    public static void main(String[] args) throws IOException {
        final Options options = cmdOptions();
        try {
            var parser = new DefaultParser();
            var cmd = parser.parse(options, args);

            var sourceFile = cmd.getOptionValue("f");
            var outputDir = cmd.getOptionValue("d");

            //TODO use an interface for this.
            // Make it pluggable. That way we could also add translation from Baton to other workflow languages/engines
            // or another implementation of Conductor DSL translator.
            translateToConductorDSL(sourceFile, outputDir);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar baton.jar -f source.baton -d ./dir/", options);
            System.exit(-1);
        }
    }

    private static void translateToConductorDSL(String sourceFile, String outputDir) throws IOException {
        var dir = getDir(outputDir);
        var charStream = CharStreams.fromFileName(sourceFile);
        var tokens = new CommonTokenStream(new BatonLexer(charStream));
        var parser = new Baton(tokens);

        //TODO change BailErrorStrategy for a custom, better error handler.
        // Should report all syntactic errors clearly
        parser.setErrorHandler(new BailErrorStrategy());
        var tree = parser.batonUnit();

        var structVisitor = new StructVisitor();
        var structDefinitions = structVisitor.visit(tree);

        var taskVisitor = new TaskVisitor(structDefinitions);
        var taskDefinitions = taskVisitor.visit(tree);

        var workflowVisitor = new WorkflowVisitor(structDefinitions, taskDefinitions);
        var workflow = workflowVisitor.visit(tree.workflowDeclaration());

        //TODO include tasks in output directory
        var jsonFilePath = getOutputJsonFilePath(dir, workflow.getName());
        try (var outputStream = output(jsonFilePath)) {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(outputStream, workflow);
        }
    }

    private static String getOutputJsonFilePath(File dir, String name) {
        if (dir == null) {
            return null;
        }

        return new File(dir, name + ".json").getPath();
    }

    private static File getDir(String outputDir) {
        if (outputDir == null) {
            return null;
        }

        File dir = new File(outputDir);
        if (!dir.isDirectory()) {
            System.out.printf("%s is not a directory %n", outputDir);
            System.exit(-1);
        }

        return dir;
    }

    private static PrintStream output(String output) throws IOException {
        if (output == null) {
            return System.out;
        }

        var file = new File(output);
        if (!file.exists() && !file.createNewFile()) {
            System.out.println("Error, couldn't create file " + output);
            System.exit(-1);
        }

        return new PrintStream(file);
    }

    private static Options cmdOptions() {
        var options = new Options();
        options.addOption(
                Option.builder("f")
                        .longOpt("file")
                        .hasArg(true)
                        .desc("Source Baton file")
                        .type(File.class)
                        .required()
                        .build());
        options.addOption(
                Option.builder("d")
                        .longOpt("out-dir")
                        .hasArg(true)
                        .type(File.class)
                        .desc("Output directory")
                        .required(false)
                        .build());
        return options;
    }
}
