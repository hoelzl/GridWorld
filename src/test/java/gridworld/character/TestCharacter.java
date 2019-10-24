package gridworld.character;

import gridworld.core.Attitude;
import gridworld.core.Character;
import gridworld.core.Location;

public class TestCharacter extends AbstractCharacter {
    TestCharacter(String name, Location location) {
        super(name, location);
    }

    @Override
    public void tick() {
    }

    @Override
    public Attitude getAttitudeTowardsPlayer() {
        return Attitude.NEUTRAL;
    }

    @Override
    public void attack(Character targetToAttack) {

    }
}
