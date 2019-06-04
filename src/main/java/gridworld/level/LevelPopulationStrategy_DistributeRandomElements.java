package gridworld.level;

import gridworld.character.NonPlayerCharacterBuilder;
import gridworld.core.*;

import java.util.Random;

@SuppressWarnings("WeakerAccess")
public class LevelPopulationStrategy_DistributeRandomElements
        implements LevelPopulationStrategy {

    public LevelPopulationStrategy_DistributeRandomElements(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public void populateLevel(Level level, Difficulty difficulty) {
        final int levelSize = level.size();
        NonPlayerCharacterBuilder builder =
                new NonPlayerCharacterBuilder(level, behavior);

        final double hostileNpcs = 0.05 * levelSize;
        final double neutralNpcs = 0.05 * levelSize;
        final double friendlyNpcs = 0.1 * levelSize;

        addRandomNpcs(builder, (int) neutralNpcs, Attitude.NEUTRAL);
        switch (difficulty) {
            case EASY:
                addRandomNpcs(builder, (int) (0.5 * hostileNpcs),
                        Attitude.HOSTILE);
                addRandomNpcs(builder, (int) (2 * friendlyNpcs),
                        Attitude.FRIENDLY);
                break;
            case MEDIUM:
                addRandomNpcs(builder, (int) hostileNpcs, Attitude.HOSTILE);
                addRandomNpcs(builder, (int) friendlyNpcs, Attitude.FRIENDLY);
                break;
            case HARD:
                addRandomNpcs(builder, (int) (2 * hostileNpcs),
                        Attitude.HOSTILE);
                addRandomNpcs(builder, (int) (0.5 * friendlyNpcs),
                        Attitude.FRIENDLY);
                break;
            case IMPOSSIBLE:
                addRandomNpcs(builder, (int) (5 * hostileNpcs),
                        Attitude.HOSTILE);
                addRandomNpcs(builder, (int) (0.5 * friendlyNpcs),
                        Attitude.FRIENDLY);
                break;
        }
    }

    void addRandomNpcs(NonPlayerCharacterBuilder builder, int numNpcs,
                       Attitude attitude) {
        assert attitude != null;

        for (int i = 0; i < numNpcs; i++) {
            builder.setAttitudeTowardsPlayer(attitude).build();
        }
    }

    private final Behavior behavior;
    private final Random rand = new Random();
}
