package hs.project.repl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Basic REPL loop for the database
 */
public class ReadExecutePrintLoop {
    private static final String userPrompt = "db > ";
    private boolean status = false;
    private String input;
    private final String[] commands = {".exit"};

    public ReadExecutePrintLoop() {
    }

    public void start() throws IOException {
        this.status = true;

        while (this.status) {
            this.printPrompt();
            this.readInput();

            if (checkCommands(input)) {
                System.out.println("Good command!");
            } else {
                System.out.println("Bad command! If you wish to see the available commands, type .help");
            }
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
    public boolean checkCommands(String command) {
        return Arrays.asList(commands).contains(command);
    }
}
