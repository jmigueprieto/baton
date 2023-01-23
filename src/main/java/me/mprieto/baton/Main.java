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
import me.mprieto.baton.listeners.ConductorJsonTranslator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final Options options = cmdOptions();
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            String sourceFile = cmd.getOptionValue("s");
            String outputFile = cmd.getOptionValue("o");

            transformToJson(sourceFile, outputFile);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar baton.jar -s source.baton -o output.json", options);
            System.exit(-1);
        }
    }

    private static void transformToJson(String sourceFile, String outputFile) throws IOException {
        try (PrintStream outputStream = output(outputFile)) {
            var charStream = CharStreams.fromFileName(sourceFile);
            var tokens = new CommonTokenStream(new BatonLexer(charStream));
            var parser = new BatonParser(tokens);
            var tree = parser.batonUnit();
            var walker = new ParseTreeWalker();
            var listener = new ConductorJsonTranslator();
            walker.walk(listener, tree);

            // listener.getWorkflows()
            // listener.getTasks()

            /*
             *  // Create a generic parse tree walker that can trigger callbacks
             *         ParseTreeWalker walker = new ParseTreeWalker();
             *         // Walk the tree created during the parse, trigger callbacks
             *         TitleParserListenerImpl titleParser = new TitleParserListenerImpl();
             *         walker.walk(titleParser, tree);
             *
             *         if (outputFile != null) {
             *             System.out.println("XML document saved to " + outputFile);
             *         }
             *
             *         XmlMapper xmlMapper = new XmlMapper();
             *         xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
             *         String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(titleParser.getParsedTitle());
             *         xmlOutput.println(xml);
             */
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
