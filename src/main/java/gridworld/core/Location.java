package gridworld.core;

import gridworld.character.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    Location(Level level) {
        this.level = level;
    }

    public Location getNeighbor(Direction direction) {
        return neighbors.getOrDefault(direction, this);
    }

    void setNeighbor(Direction direction, Location neighbor) {
        neighbors.put(direction, neighbor);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    public void addCharacter(Character character) {
        assert !characters.contains(character);
        characters.add(character);
    }

    public Level getLevel() {
        return level;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    private Level level;
    private Map<Direction, Location> neighbors = new HashMap<>();
    private List<Character> characters = new ArrayList<>();

    public int getW() {
        return w;
    }

    void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    void setH(int h) {
        this.h = h;
    }

    private int w;
    private int h;
}
