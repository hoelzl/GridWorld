package gridworld.core;

import gridworld.character.NonPlayerCharacter;

import java.util.List;

public interface Behavior {
    List<Command> getCommandsForCurrentTurn(NonPlayerCharacter character,
                                            Level level);

    void tick(NonPlayerCharacter nonPlayerCharacter, Level level);
}
