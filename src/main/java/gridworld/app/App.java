package gridworld.app;

import gridworld.core.Difficulty;
import gridworld.game.Game;
import org.beryx.textio.StringInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class App {
    App() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();
        //        inputReader = textIO.newStringInputReader()
        //                .withInlinePossibleValues("Foo", "Bar", "Quux");
        //        inputReader = textIO.newStringInputReader()
        //                .withNumberedPossibleValues("Foo", "Bar", "Quux");
        inputReader = textIO.newStringInputReader().withPattern("[afb].*");
    }

    public static void main(String[] args) {
        Game game = new Game(Difficulty.MEDIUM);

        App app = new App();
        app.terminal.printf("Hello, world!\n");

        String s = app.inputReader.read("Input a string: ");
        app.terminal.printf("You entered: %s", s);
    }

    private TextTerminal terminal;
    private StringInputReader inputReader;
}
