package hs.project.repl;

import hs.project.repl.ReadExecutePrintLoopManager.ReadExecutePrintLoopManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Basic REPL loop for the database
 */
public class ReadExecutePrintLoop {
    private static final String userPrompt = "db > ";
    private boolean status = false;
    private String input;

    public ReadExecutePrintLoop() {
    }

    public void start() throws IOException {
        this.status = true;

        while (this.status) {
            this.printPrompt();
            this.readInput();

            ReadExecutePrintLoopManager readExecutePrintLoopManager = new ReadExecutePrintLoopManager();
            readExecutePrintLoopManager.managePages(input);

        }
    }

    public boolean getStatus() {
        return status;
    }

    private void printPrompt() {
        System.out.print(userPrompt);
    }

    public void readInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            this.input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
