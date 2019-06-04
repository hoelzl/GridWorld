package gridworld.core;

public interface GameCharacter {
    void die();

    void move(Direction direction);

    Location getLocation();

    void setLocation(Location newLocation);

    String getName();
}
