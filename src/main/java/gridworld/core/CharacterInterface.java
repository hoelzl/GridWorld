package gridworld.core;

public interface CharacterInterface {
    void die();

    void move(Direction direction);

    Location getLocation();

    String getName();

    void tick();

    Attitude getAttitudeTowardsPlayer();

    void attack(CharacterInterface targetToAttack);
}
