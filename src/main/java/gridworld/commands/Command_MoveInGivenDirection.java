package gridworld.commands;

import gridworld.character.AbstractCharacter;
import gridworld.core.Command;
import gridworld.core.Direction;

public class Command_MoveInGivenDirection implements Command {
    public Command_MoveInGivenDirection(AbstractCharacter character,
                                        Direction direction) {
        this.character = character;
        this.direction = direction;
    }

    @Override
    public void execute() {
        character.move(direction);
    }

    @Override
    public String getDescription() {
        return "Move in direction " + direction.toString();
    }

    private AbstractCharacter character;
    private Direction direction;
}
