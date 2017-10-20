import interfaces.IPrinter;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Printer implements IPrinter {
    private PrintStream printStream;

    public void printMessage(String message) {
        System.out.println(UnicornTheme.ANSI_RESET + formatMessage(message));
    }

    public void printEditText(String message) {
        System.out.print(message + "%\r");
    }

    public long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public String formatMessage(String message) {
        return ">>> " + message + " <<<";
    }
}
