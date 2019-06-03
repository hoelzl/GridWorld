package gridworld.character;

import gridworld.core.Attitude;
import gridworld.core.Direction;
import gridworld.core.Location;

public abstract class Character {
    Character(String name, Location location) {
        assert location != null;

        this.name = name;
        setLocation(location);
        location.getLevel().noteCharacterCreation(this);
    }

    public void die() {
        location.getLevel().noteCharacterDeath(this);
    }

    public void move(Direction direction) {
        Location newLocation = location.getNeighbor(direction);

        assert newLocation != null;
        assert location.getLevel() == newLocation.getLevel();

        location.getLevel().noteCharacterMove(this, newLocation);
        setLocation(newLocation);
    }

    public Location getLocation() {
        return location;
    }

    void setLocation(Location newLocation) {
        assert newLocation != null;

        if (newLocation != location) {
            // location may be null when calling this from the constructor
            if (location != null) {
                location.removeCharacter(this);
            }
            location = newLocation;
            location.addCharacter(this);
        }
    }

    public String getName() {
        return name;
    }

    public abstract void tick();

    public abstract Attitude getAttitudeTowardsPlayer();

    public abstract void attack(Character targetToAttack);

    private String name;
    private Location location;
}
