package gridworld.core;

import gridworld.character.NonPlayerCharacter;

import java.util.List;

public interface Behavior {
    List<Command> getCommandsForCurrentTurn(NonPlayerCharacter character,
                                            Level level);

    default void tick(NonPlayerCharacter nonPlayerCharacter, Level level) {
        List<Command> commands =
                getCommandsForCurrentTurn(nonPlayerCharacter, level);
        for (Command command : commands) {
            command.execute();
        }
    }
}
