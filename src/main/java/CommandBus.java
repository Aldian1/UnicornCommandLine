//contains all possible commands for the application

public class CommandBus {

    private FileHandler fileHandler;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String newPath) {
        fileName = newPath;
    }

    public CommandBus() {
        fileHandler = new FileHandler();
        fileName = "default.txt";
    }

    public boolean processCommand(String command) {
        String[] commandSplit = splitCommand(command);
        if (commandSplit.length < 1) return false;
        else if (commandSplit.length > 1) {
            setFileName(commandSplit[1]);
        }
        try {
            switch (commandSplit[0]) {
                default:
                    Printer printer = new Printer();
                    printer.printMessage("Available commands: ");
                    printer.printMessage("new [filename] - makes a new txt file");
                    printer.printMessage("open [filename] - opens file in text editor");
                    printer.printMessage("remove [filename] - removes specified file");
                    printer.printMessage("copy [filename] [newFilename] - copies a file");
                    return false;
                case "open":
                    return fileHandler.openFile(getFileName());
                case "new":
                    return fileHandler.createNewFile(getFileName());
                case "remove":
                    return fileHandler.removeFile(getFileName());
                case "copy":
                    return fileHandler.copyFile(getFileName(), commandSplit[2]);
                case "help":
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String[] splitCommand(String command) {
        if (command.indexOf(' ') > -1) {
            if (command.indexOf(' ') > 2) {
                return command.split(" ", 3);
            } else {
                return command.split(" ", 2);
            }
        }
        return new String[]{command};

    }
}