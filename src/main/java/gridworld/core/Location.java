package gridworld.core;

import java.util.HashMap;
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

    public Level getLevel() {
        return level;
    }

    private Level level;
    private Map<Direction, Location> neighbors = new HashMap<>();

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
