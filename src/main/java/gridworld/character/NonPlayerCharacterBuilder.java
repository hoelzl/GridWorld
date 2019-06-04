package gridworld.character;

import gridworld.core.Attitude;
import gridworld.core.Behavior;
import gridworld.core.Level;
import gridworld.core.Location;

import java.util.Random;

public class NonPlayerCharacterBuilder {
    private static int serial = 0;

    public NonPlayerCharacterBuilder(Level level, Behavior defaultBehavior) {
        assert level != null;

        this.level = level;
        this.defaultBehavior = defaultBehavior;
        reset();
    }

    public NonPlayerCharacterBuilder(Level level) {
        this(level, null);
    }

    private void reset() {
        name = "<unnamed character " + serial++ + ">";
        location = pickRandomLocation(level);
        attitudeTowardsPlayer = Attitude.NEUTRAL;
        behavior = defaultBehavior;
    }

    private Location pickRandomLocation(Level level) {
        int w = random.nextInt(level.getWidth());
        int h = random.nextInt(level.getHeight());
        return level.get(w, h);
    }

    public NonPlayerCharacter build() {
        assert name != null && location != null;
        assert attitudeTowardsPlayer != null;

        var result =
                new NonPlayerCharacter(name, location, attitudeTowardsPlayer,
                        behavior);
        reset();
        return result;
    }

    public NonPlayerCharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public NonPlayerCharacterBuilder setLocation(Location location) {
        this.location = location;
        return this;
    }

    public NonPlayerCharacterBuilder setAttitudeTowardsPlayer(
            Attitude attitudeTowardsPlayer) {
        this.attitudeTowardsPlayer = attitudeTowardsPlayer;
        return this;
    }

    public NonPlayerCharacterBuilder setBehavior(Behavior behavior) {
        this.behavior = behavior;
        return this;
    }
    private Attitude attitudeTowardsPlayer;
    private Behavior defaultBehavior;
    private Behavior behavior;
    private Level level;
    private Random random = new Random();
    private String name;
    private Location location;
}
