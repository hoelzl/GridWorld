package gridworld.character;

import gridworld.core.Attitude;
import gridworld.core.CharacterInterface;
import gridworld.core.Location;

public class Player extends Character {
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
    public void attack(CharacterInterface targetToAttack) {
        // TODO
    }
}
