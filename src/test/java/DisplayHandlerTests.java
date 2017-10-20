import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DisplayHandlerTests {
    public DisplayHandler displayHandler;

    public DisplayHandlerTests() {
        displayHandler = new DisplayHandler();
    }

    @Test
    public void testCalculateTextDifference() {
        String test1 = "Hello this is some text.";
        String test2 = "Hello this is some text with a bit more.";
        assertEquals(16, displayHandler.calculateEditDifference(test2, test1));
    }

    @Test
    public void testPopulateJTextArea() {
        List<String> mag = new ArrayList<>();
        mag.add("Item1");
        mag.add("Item2");
        mag.add("Item3");
        String p = displayHandler.convertListToString(mag);
        String i = "";
        for (String t : mag) {
            i += "\n" + t;
        }
        assertEquals(p, i);
    }

}
