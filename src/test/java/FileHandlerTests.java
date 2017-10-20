import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileHandlerTests {

    private FileHandler fileHandler;

    final String testFileName = "testFile";
    final String testFileNameCopy = "testFileCopy";

    public FileHandlerTests() {
        fileHandler = new FileHandler();
    }

    @Test
    public void testCreateNewFile() throws IOException {
        assertEquals(true, fileHandler.createNewFile(testFileName));
    }

    @Test
    public void testOpenFile() throws IOException {
        assertEquals(true, fileHandler.openFile(testFileName));
    }

    @Test
    public void testCopyFile() throws IOException {
        assertEquals(true, fileHandler.copyFile(testFileName, testFileNameCopy));
    }

    @Test
    public void testRemoveFile() throws IOException {
        assertEquals(true, fileHandler.removeFile(testFileName));
        assertEquals(true, fileHandler.removeFile(testFileNameCopy));
    }
}
