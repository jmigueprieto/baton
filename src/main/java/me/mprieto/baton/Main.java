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


import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.visitors.StructVisitor;
import me.mprieto.baton.visitors.TaskVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final Options options = cmdOptions();
        try {
            var parser = new DefaultParser();
            var cmd = parser.parse(options, args);

            var sourceFile = cmd.getOptionValue("f");
            var outputDir = cmd.getOptionValue("d");

            transformToJson(sourceFile, outputDir);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar baton.jar -f source.baton -d ./dir/", options);
            System.exit(-1);
        }
    }

    private static void transformToJson(String sourceFile, String outputFile) throws IOException {
        try (PrintStream outputStream = output(outputFile)) {
            var charStream = CharStreams.fromFileName(sourceFile);
            var tokens = new CommonTokenStream(new BatonLexer(charStream));
            var parser = new BatonParser(tokens);
            var tree = parser.batonUnit();

            /* ## Listener Example
             * 1. Create a parse tree walker that can trigger callbacks
             * ```
             * var walker = new ParseTreeWalker();
             * ```
             * 2. Walk the tree created during the parse, trigger callbacks
             * ```
             * var listener = new BatonListenerImpl();
             * walker.walk(titleParser, tree);
             * ```
             */

            var structVisitor = new StructVisitor();
            var structs = structVisitor.visit(tree);

            var taskVisitor = new TaskVisitor(structs);
            var tasks = taskVisitor.visit(tree);

            //TODO Walk the tree to load the workflow
            //TODO translate to JSON
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
                Option.builder("s")
                        .longOpt("source")
                        .hasArg(true)
                        .desc("Source file in Baton format")
                        .type(File.class)
                        .required()
                        .build());
        options.addOption(
                Option.builder("o")
                        .longOpt("output")
                        .hasArg(true)
                        .type(File.class)
                        .desc("Output file in JSON Format")
                        .required(false)
                        .build());
        return options;
    }
}
