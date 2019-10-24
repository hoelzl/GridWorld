package gridworld.core;

public interface Character {
    void die();

    void move(Direction direction);

    Location getLocation();

    String getName();

    void tick();

    Attitude getAttitudeTowardsPlayer();

    void attack(Character targetToAttack);
}
