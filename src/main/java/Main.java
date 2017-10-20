import java.io.IOException;

public class Main {
    private CommandBus commandBus;
    private InputReader inputReader;
    private Printer printer;
    private FileHandler fileHandler;
    public static void main(String[] args) {
        Main m = new Main();
    }

    public Main() {
        inputReader = new InputReader();
        commandBus = new CommandBus();
        printer = new Printer();
        try {
            onEntry();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void onEntry() throws IOException{
        do {
            String input = inputReader.captureUserInput();
            boolean commandBusResult = commandBus.processCommand(input);
            if(commandBusResult) {
                printer.printMessage("Enter a new query");
            }else{
                printer.printMessage("Command not found");
            }
        } while (true);
    }
}
