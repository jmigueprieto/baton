package me.mprieto.baton;

import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonLexer;
import org.antlr.v4.gui.TestRig;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class BatonTestRig extends TestRig {

    public static void main(String[] args) throws Exception {
        var testRig = new BatonTestRig(getArgs(args));
        if (args.length >= 1) {
            testRig.process();
        }
    }

    static String[] getArgs(String[] array) {
        var resultList = new ArrayList<String>(array.length + 1);
        resultList.add("Baton");
        Collections.addAll(resultList, array);
        return resultList.toArray(new String[0]);
    }

    public BatonTestRig(String[] args) throws Exception {
        super(args);
    }


    public void process() throws Exception {
        Lexer lexer = new BatonLexer(null);
        Class<? extends Parser> parserClass = null;
        Parser parser = null;
        if (!startRuleName.equals(LEXER_START_RULE_NAME)) {
            parserClass = Baton.class;
            parser = new Baton(null);
        }

        Charset charset = (encoding == null ? Charset.defaultCharset() : Charset.forName(encoding));
        if (inputFiles.size() == 0) {
            CharStream charStream = CharStreams.fromStream(System.in, charset);
            process(lexer, parserClass, parser, charStream);
            return;
        }
        for (String inputFile : inputFiles) {
            CharStream charStream = CharStreams.fromPath(Paths.get(inputFile), charset);
            if (inputFiles.size() > 1) {
                System.err.println(inputFile);
            }
            process(lexer, parserClass, parser, charStream);
        }
    }
}
