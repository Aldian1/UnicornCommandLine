import interfaces.IInputReader;

import java.util.Scanner;

public class InputReader implements IInputReader {

    public String captureUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
