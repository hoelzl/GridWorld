package gridworld.app;

import org.beryx.textio.StringInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class App {
    private TextTerminal<?> terminal;

    App() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();
        inputReader = textIO.newStringInputReader().withInlinePossibleValues("Foo", "Bar", "Quux");
    }

    public static void main(String[] args) {
        App app = new App();
        app.terminal.printf("Starting Game!\n\n");
        app.terminal.printf("Game over.\n");
        // System.exit(0);
    }
    private StringInputReader inputReader;
}
