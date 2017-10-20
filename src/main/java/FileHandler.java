import interfaces.IFileHandler;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements IFileHandler {
    private Printer printer;
    private DisplayHandler displayHandler;
    private List<String> textData;

    public FileHandler() {
        printer = new Printer();
        displayHandler = new DisplayHandler();
        textData = new ArrayList<>();
    }

    @Override
    public boolean openFile(String fileName) throws IOException {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName + ".txt"));
            String text = new String(bytes, StandardCharsets.UTF_8);
            textData.add(text);
            editFile(fileName + ".txt");
            return true;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read:  ", fileName);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveFile(String fileName, String textToSave) {
        try {
            BufferedWriter writer = new BufferedWriter((new FileWriter(fileName)));
            writer.write(textToSave);
            writer.close();
            return true;
        } catch (Exception e) {
            printer.printMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public void editFile(String fileName) {
        displayHandler.initUnicornUI(textData, fileName);
    }

    @Override
    public boolean copyFile(String fileName, String newFileName) throws IOException {
        if (fileName != null) {
            FileChannel sourceChannel = null;
            FileChannel destChannel = null;
            try {
                sourceChannel = new FileInputStream(fileName + ".txt").getChannel();
                destChannel = new FileOutputStream(newFileName + ".txt").getChannel();
                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
                printer.printMessage("Succesfully copied " + fileName + ".txt too " + newFileName + ".txt");
                return true;
            }catch(Exception e){ e.printStackTrace();}
        }
        return  false;
    }

    @Override
    public boolean createNewFile(String fileName) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(fileName + ".txt");
            OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
            fos.close();
            out.close();
            printer.printMessage("Succesfully created " + fileName + ".txt");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename + ".txt");
        fos.close();
        File f = new File(filename + ".txt");
        boolean delete = f.delete();
        if (delete) {
            printer.printMessage("Deleted file: " + filename);
            return true;
        } else {
            printer.printMessage("Error: Cant find file");
            return false;
        }
    }
}