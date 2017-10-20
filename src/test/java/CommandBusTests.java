import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandBusTests {

    private CommandBus commandBus;

    public CommandBusTests() {
        commandBus = new CommandBus();
    }

    @Test
    public void testSetGetCurrentPath() {
        //assertEquals();
    }

    @Test
    public void testSplitCommand() {
        String[] result = commandBus.splitCommand("new file");
        assertEquals("new", result[0]);
    }

    @Test
    public void testCreateCommand() {
        assertEquals(true, commandBus.processCommand("new magic"));
    }

    @Test
    public void testCopyCommand() {
        assertEquals(true, commandBus.processCommand("copy magic magic2"));
    }

    @Test
    public void testOpenCommand() {
        assertEquals(true, commandBus.processCommand("open magic"));
    }

    @Test
    public void testRemoveCommand() {
        assertEquals(true, commandBus.processCommand("remove magic.txt"));
        assertEquals(true, commandBus.processCommand("remove magic2.txt"));
    }

    @Test
    public void testCommandFailure() {
        assertEquals(false, commandBus.processCommand("destroy everything"));
    }

}
