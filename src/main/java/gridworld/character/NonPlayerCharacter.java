package gridworld.character;

import gridworld.core.*;

import java.util.Collections;
import java.util.List;

public class NonPlayerCharacter extends Character {
    public NonPlayerCharacter(String name, Location location) {
        super(name, location);
    }

    @Override
    public void tick() {
        if (behavior != null) {
            behavior.tick(this, getLocation().getLevel());
        }
    }

    @Override
    public Attitude getAttitudeTowardsPlayer() {
        return attitudeTowardsPlayer;
    }

    @Override
    public void attack(Character targetToAttack) {
        // TODO
    }

    List<Command> getCommandsForCurrentTurn(Level level) {
        assert level != null;
        if (behavior != null) {
            return behavior.getCommandsForCurrentTurn(this, level);
        }
        return Collections.emptyList();
    }

    Attitude attitudeTowardsPlayer = Attitude.NEUTRAL;
    Behavior behavior;
}
