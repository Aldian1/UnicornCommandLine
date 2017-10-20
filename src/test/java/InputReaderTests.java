import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InputReaderTests {

    private InputReader inputReader;

    public InputReaderTests() {
        inputReader = new InputReader();
    }

    @Test
    public void testUserInput() {
        String data = ">>> Testing input <<<";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());

    }
}
