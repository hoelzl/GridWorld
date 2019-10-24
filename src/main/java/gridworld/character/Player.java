package gridworld.character;

import gridworld.core.Attitude;
import gridworld.core.Character;
import gridworld.core.Location;

public class Player extends AbstractCharacter {
    public Player(String name, Location location) {
        super(name, location);
    }

    @Override
    public void tick() {
        // Nothing to do.
    }

    @Override
    public Attitude getAttitudeTowardsPlayer() {
        return Attitude.FRIENDLY;
    }

    @Override
    public void attack(Character targetToAttack) {
        // TODO
    }
}
