import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


//Using Swing to handle UI as it is included with java.....

public class DisplayHandler {

    private Printer printer;
    private JTextArea editArea;
    private JPanel gui;
    private Font font;
    private JFrame f;
    private String injectedText;
    private String pathreference;

    public DisplayHandler() {
        printer = new Printer();

    }

    public void initUnicornUI(List<String> currentList, String fileName) {
        constructUI();
        pathreference = fileName;
        printer.printMessage("Opening file: " + fileName + "");
        printer.printMessage("Loading");
        injectedText = convertListToString(currentList);
        editArea.append(injectedText);
        initWindowListener();
    }

    private void initWindowListener() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                closedWindow();
            }
        });
    }

    private void closedWindow() {
        FileHandler fileHandler = new FileHandler();
        printer.printMessage("Changed " + String.valueOf(calculateEditDifference(editArea.getText(), injectedText)) + " characters");
        printer.printMessage("Closed Window");
        fileHandler.saveFile(pathreference, editArea.getText());
    }

    public int calculateEditDifference(String oldText, String newText) {
        if (oldText.length() > newText.length()) {
            return oldText.length() - newText.length();
        } else {
            return newText.length() - oldText.length();
        }

    }

    public String convertListToString(List<String> currentList) {
        StringBuilder o = new StringBuilder();
        for (String c : currentList) {
            o.append("\n").append(c);
        }
        return o.toString();
    }

    private void constructUI() {
        gui = new JPanel(new BorderLayout());
        gui.setBorder(new EmptyBorder(2, 3, 2, 3));
        editArea = new JTextArea(5, 40);
        font = new Font(Font.MONOSPACED, Font.PLAIN, editArea.getFont().getSize());
        editArea.setFont(font);
        gui.add(new JScrollPane(editArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        f = new JFrame("======================= Unicorn editor v0.1 =======================");
        f.add(gui);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.pack();
        f.setVisible(true);
    }
}




