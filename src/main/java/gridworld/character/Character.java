package gridworld.character;

import gridworld.core.CharacterInterface;
import gridworld.core.Direction;
import gridworld.core.Location;

public abstract class Character implements CharacterInterface {
    Character(String name, Location location) {
        assert location != null;

        this.name = name;
        setLocation(location);
        location.getLevel().noteCharacterCreation(this);
    }

    @Override
    public void die() {
        location.getLevel().noteCharacterDeath(this);
    }

    @Override
    public void move(Direction direction) {
        Location newLocation = location.getNeighbor(direction);

        assert newLocation != null;
        assert location.getLevel() == newLocation.getLevel();

        location.getLevel().noteCharacterMove(this, newLocation);
        setLocation(newLocation);
    }

    @Override
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

    @Override
    public String getName() {
        return name;
    }

    private String name;
    private Location location;
}
