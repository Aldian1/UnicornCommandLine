package interfaces;

import java.io.IOException;

public interface IFileHandler {

    boolean openFile(String fileName) throws IOException;
    boolean saveFile(String fileName, String textToSave);
    void editFile(String path);
    boolean copyFile(String fileName, String newFileName) throws IOException;

    boolean createNewFile(String fileName) throws IOException;
    boolean removeFile(String fileName) throws IOException;
}
