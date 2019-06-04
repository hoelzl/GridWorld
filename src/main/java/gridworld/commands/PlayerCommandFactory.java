package gridworld.commands;

import gridworld.character.Player;
import gridworld.core.Command;
import gridworld.core.Direction;

public class PlayerCommandFactory {
    public PlayerCommandFactory(Player player) {
        this.player = player;
    }

    public Command createCommand(String input) {
        switch (input) {
            case "Go North":
                return new Command_MoveInGivenDirection(player,
                        Direction.NORTH);
            case "Go East":
                return new Command_MoveInGivenDirection(player, Direction.EAST);
            case "Go South":
                return new Command_MoveInGivenDirection(player,
                        Direction.SOUTH);
            case "Go West":
                return new Command_MoveInGivenDirection(player, Direction.WEST);
            default:
                return new Command_MoveInRandomDirection(player, 1.0);
        }
    }

    private Player player;
}
