package hs.project.repl.ReadExecutePrintLoopManager;

import hs.project.repl.commandParser.CommandParser;

public class ReadExecutePrintLoopManager {

    public void managePages(String input) {
        if (CommandParser.isCommandAvailable(input)) {
            System.out.println("Good command!");
        } else {
            System.out.println("Bad command!");
        }
    }
}
