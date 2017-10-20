import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrinterTests {
    Printer printer;

    public PrinterTests() {
        printer = new Printer();
    }

    @Test
    public void testPrinterMessage() {
        printer.printMessage("Printer test");
    }

    @Test
    public void testPrinterGetTimeStamp() {
        long result = printer.getTimeStamp();
        long currentTime = System.currentTimeMillis();
        assertTrue("Method timestamp (" + result + ") should be greater than or equal too current timestamp (" + currentTime + ")", result >= currentTime);
    }

    @Test
    public void testPrinterMessageFormat() {
        assertEquals(">>> Formatted Message <<<", printer.formatMessage("Formatted Message"));
    }

}
