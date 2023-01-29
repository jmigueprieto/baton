/*
 * Copyright 2023 Netflix, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package me.mprieto.baton;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.structs.StructVisitor;
import me.mprieto.baton.tasks.TaskVisitor;
import me.mprieto.baton.workflows.WorkflowListener;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
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

            translateToConductorDSL(sourceFile, outputDir);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar baton.jar -f source.baton -d ./dir/", options);
            System.exit(-1);
        }
    }

    private static void translateToConductorDSL(String sourceFile, String outputFile) throws IOException {
        try (PrintStream outputStream = output(outputFile)) {
            var charStream = CharStreams.fromFileName(sourceFile);
            var tokens = new CommonTokenStream(new BatonLexer(charStream));
            var parser = new Baton(tokens);

            parser.setErrorHandler(new BailErrorStrategy());
            var tree = parser.batonUnit();

            var structVisitor = new StructVisitor();
            var structDefinitions = structVisitor.visit(tree);

            var taskVisitor = new TaskVisitor(structDefinitions);
            var taskDefinitions = taskVisitor.visit(tree);

            var listener = new WorkflowListener(structDefinitions, taskDefinitions);
            var walker = new ParseTreeWalker();
            walker.walk(listener, tree);

            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(outputStream, listener.getWorkflowDef());
        }
    }

    private static PrintStream output(String output) throws IOException {
        PrintStream out;
        if (output == null) {
            out = System.out;
        } else {
            File file = new File(output);
            if (!file.exists() && !file.createNewFile()) {
                System.out.println("Error, couldn't create file " + output);
                System.exit(-1);
            }

            out = new PrintStream(file);
        }

        return out;
    }

    private static Options cmdOptions() {
        Options options = new Options();
        options.addOption(
                Option.builder("f")
                        .longOpt("file")
                        .hasArg(true)
                        .desc("Source file in Baton format")
                        .type(File.class)
                        .required()
                        .build());
        options.addOption(
                Option.builder("d")
                        .longOpt("output")
                        .hasArg(true)
                        .type(File.class)
                        .desc("Output directory")
                        .required(false)
                        .build());
        return options;
    }
}
