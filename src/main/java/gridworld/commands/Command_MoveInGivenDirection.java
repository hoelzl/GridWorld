package gridworld.commands;

import gridworld.character.Character;
import gridworld.core.Command;
import gridworld.core.Direction;

public class Command_MoveInGivenDirection implements Command {
    public Command_MoveInGivenDirection(Character character,
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

    private Character character;
    private Direction direction;
}
