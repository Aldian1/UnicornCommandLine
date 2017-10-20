package interfaces;

import java.io.FileNotFoundException;

public interface IPrinter{

    void printMessage(String message) throws FileNotFoundException;
    void printEditText(String message);
    long getTimeStamp();
    String formatMessage(String message);
}
