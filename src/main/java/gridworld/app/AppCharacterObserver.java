package gridworld.app;

import gridworld.character.Character;
import gridworld.core.CharacterObserver;
import gridworld.core.Location;
import org.beryx.textio.TextTerminal;

public class AppCharacterObserver implements CharacterObserver {
    AppCharacterObserver(TextTerminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public void onCharacterCreation(Character character) {
        Location location = character.getLocation();
        terminal.printf("Created character %s at (%d, %d).\n",
                character.getName(), location.getW(), location.getH());
    }

    @Override
    public void onCharacterMove(Character character, Location newLocation) {
        Location location = character.getLocation();
        terminal.printf("Character %s moved from (%d, %d) to (%d, %d).\n",
                character.getName(), location.getW(), location.getH(),
                newLocation.getW(), newLocation.getH());
    }

    @Override
    public void onCharacterDeath(Character character) {
        terminal.printf("Character %s died.\n", character.getName());
    }

    private TextTerminal terminal;
}
