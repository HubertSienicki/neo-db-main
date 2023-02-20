package hs.project.repl.commandParser;

import java.util.Arrays;

public class CommandParser {
    private static final String[] commands = {".exit", ".help"};
    public static boolean isCommandAvailable(String command) {
        return Arrays.asList(commands).contains(command);
    }
}
