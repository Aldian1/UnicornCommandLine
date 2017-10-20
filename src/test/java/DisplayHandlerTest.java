import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class DisplayHandlerTest {

    private DisplayHandler displayHandler = new DisplayHandler();

    @Test
    public void initUnicornUI() throws Exception {
        List<String> tempList = new ArrayList<>();
        tempList.add("1");
        tempList.add("2");
        tempList.add("3");
        displayHandler.initUnicornUI(tempList, "test.txt");
    }

    @Test
    public void calculateEditDifference() throws Exception {
        assertEquals(1, displayHandler.calculateEditDifference("ee", "ooo"));
    }

    @Test
    public void testConvertListToString() throws Exception {
        List<String> tempList = new ArrayList<>();
        for(int i =0; i < 50000; i++) {
        tempList.add(UUID.randomUUID().toString());
        }
        String result = displayHandler.convertListToString(tempList);
        String[] result2 = result.split("\n", 3);
        System.out.println("First entry in list: " + tempList.get(0));
        System.out.println("First entry in string: " + result2[1]);
        assertEquals(true, tempList.get(0).equals(result2[1]));
    }
}