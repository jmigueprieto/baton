package mprieto.baton;

import lombok.SneakyThrows;
import me.mprieto.baton.grammar.BatonLexer;
import me.mprieto.baton.grammar.BatonParser;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class TestUtils {

    @SneakyThrows
    public static BatonParser.BatonUnitContext fromResource(String resource) {
        try (var is = TestUtils.class.getResourceAsStream(resource)) {
            assert is != null;
            var charStream = CharStreams.fromStream(is);
            var tokens = new CommonTokenStream(new BatonLexer(charStream));
            var parser = new BatonParser(tokens);
            parser.setErrorHandler(new BailErrorStrategy());
            return parser.batonUnit();
        }
    }
}
