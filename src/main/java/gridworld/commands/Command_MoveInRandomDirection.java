package gridworld.commands;

import gridworld.character.AbstractCharacter;
import gridworld.core.Command;
import gridworld.core.Direction;

import java.util.Random;

public class Command_MoveInRandomDirection implements Command {
    private static Direction[] directions = Direction.values();

    public Command_MoveInRandomDirection(AbstractCharacter character,
                                         double moveProbability) {
        this.character = character;
        Random random = new Random();
        if (random.nextDouble() < moveProbability) {
            performMove = true;
            direction = directions[random.nextInt(directions.length)];
        }
    }

    @Override
    public void execute() {
        if (performMove) {
            character.move(direction);
        }
    }

    @Override
    public String getDescription() {
        return "Move in a random direction";
    }

    private AbstractCharacter character;
    private boolean performMove = false;
    private Direction direction = Direction.NORTH;
}
