package gridworld.app;

import org.beryx.textio.StringInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class App {
    App() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();
        inputReader = textIO.newStringInputReader()
                .withNumberedPossibleValues("Go North", "Go East", "Go South",
                        "Go West");
    }

    public static void main(String[] args) {
        App app = new App();
        app.terminal.printf("Starting Game!\n\n");
    }

    private TextTerminal terminal;
    private StringInputReader inputReader;
}
