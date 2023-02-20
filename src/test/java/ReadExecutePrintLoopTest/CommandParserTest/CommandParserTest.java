package ReadExecutePrintLoopTest.CommandParserTest;

import hs.project.repl.commandParser.CommandParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandParserTest {

    @Test
    public void parserShouldReturnTrue(){
        String command = ".exit";
        Assertions.assertTrue(CommandParser.isCommandAvailable(command));
    }
}
