package gridworld.app;

import gridworld.commands.PlayerCommandFactory;
import gridworld.core.Command;
import gridworld.core.Difficulty;
import gridworld.game.Game;
import org.beryx.textio.StringInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.util.Collections;

public class App {
    App() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();
        //        inputReader = textIO.newStringInputReader()
        //                .withInlinePossibleValues("Foo", "Bar", "Quux");
        inputReader = textIO.newStringInputReader()
                .withNumberedPossibleValues("Go North", "Go East", "Go South",
                        "Go West");
    }

    public static void main(String[] args) {
        App app = new App();
        AppCharacterObserver observer = new AppCharacterObserver(app.terminal);
        app.terminal.printf("Starting Game!\n\n");

        Game game = new Game(Difficulty.MEDIUM, 8, 6,
                Collections.singletonList(observer));
        PlayerCommandFactory commandFactory =
                new PlayerCommandFactory(game.getPlayer());

        while (!game.isFinished()) {
            String action = app.inputReader.read("Enter your action: ");
            Command command = commandFactory.createCommand(action);
            command.execute();
            game.tick();
        }

        System.exit(0);
    }

    private TextTerminal terminal;
    private StringInputReader inputReader;
}
