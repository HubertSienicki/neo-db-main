package ReadExecutePrintLoopTest;

import hs.project.repl.ReadExecutePrintLoop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

public class ReadExecutePrintLoopTest {

    @Mock
    private ReadExecutePrintLoop replTest;
    @Test
    public void readExecutePrintLoopIsRunning() throws IOException {
        replTest = new ReadExecutePrintLoop();
        replTest.start();
    }

    @Test
    public void statusIsChanged() throws IOException {
        replTest = new ReadExecutePrintLoop();
        replTest.start();
        Assertions.assertTrue(replTest.getStatus());
    }
}

