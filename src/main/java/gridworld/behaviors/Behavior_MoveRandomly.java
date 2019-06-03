package gridworld.behaviors;

import gridworld.character.NonPlayerCharacter;
import gridworld.commands.Command_MoveInRandomDirection;
import gridworld.core.Behavior;
import gridworld.core.Command;
import gridworld.core.Level;

import java.util.Collections;
import java.util.List;

public class Behavior_MoveRandomly implements Behavior {
    @Override
    public List<Command> getCommandsForCurrentTurn(NonPlayerCharacter character,
                                                   Level level) {
        return Collections.singletonList(
                new Command_MoveInRandomDirection(character,
                        movementProbability));
    }

    @Override
    public void tick(NonPlayerCharacter nonPlayerCharacter, Level level) {

    }

    private Double movementProbability = 0.5;
}
