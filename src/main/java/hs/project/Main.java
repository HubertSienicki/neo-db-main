package hs.project;

import hs.project.repl.ReadExecutePrintLoop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ReadExecutePrintLoop readExecutePrintLoop = new ReadExecutePrintLoop();

        try {
            readExecutePrintLoop.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
