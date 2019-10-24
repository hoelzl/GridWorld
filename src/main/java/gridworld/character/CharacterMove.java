package gridworld.character;

import gridworld.character.Character;
import gridworld.core.Location;

public class CharacterMove {
    public CharacterMove(Character character, Location fromLocation,
                         Location toLocation) {
        this.character = character;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public Character getCharacter() {
        return character;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    private Character character;
    private Location fromLocation;
    private Location toLocation;
}
