package gridworld.app;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class App {
    App() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();
    }

    public static void main(String[] args) {
        App app = new App();
        app.terminal.printf("Hello, world!");
    }

    private TextTerminal terminal;
}
