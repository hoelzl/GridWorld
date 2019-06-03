package gridworld.level;

import gridworld.character.NonPlayerCharacterBuilder;
import gridworld.core.*;

import java.util.Random;

@SuppressWarnings("WeakerAccess")
public class LevelPopulationStrategy_DistributeRandomElements
        implements LevelPopulationStrategy {

    public LevelPopulationStrategy_DistributeRandomElements(Level level,
                                                            Behavior behavior) {
        this.level = level;
        this.builder = new NonPlayerCharacterBuilder(level, behavior);
    }

    public LevelPopulationStrategy_DistributeRandomElements(Level level) {
        this(level, null);
    }

    @Override
    public void populateLevel(Difficulty difficulty) {
        final int levelSize = level.size();
        final double hostileNpcs = 0.05 * levelSize;
        final double neutralNpcs = 0.05 * levelSize;
        final double friendlyNpcs = 0.1 * levelSize;

        addRandomNpcs((int) neutralNpcs, Attitude.NEUTRAL);
        switch (difficulty) {
            case EASY:
                addRandomNpcs((int) (0.5 * hostileNpcs), Attitude.HOSTILE);
                addRandomNpcs((int) (2 * friendlyNpcs), Attitude.FRIENDLY);
                break;
            case MEDIUM:
                addRandomNpcs((int) hostileNpcs, Attitude.HOSTILE);
                addRandomNpcs((int) friendlyNpcs, Attitude.FRIENDLY);
                break;
            case HARD:
                addRandomNpcs((int) (2 * hostileNpcs), Attitude.HOSTILE);
                addRandomNpcs((int) (0.5 * friendlyNpcs), Attitude.FRIENDLY);
                break;
            case IMPOSSIBLE:
                addRandomNpcs((int) (5 * hostileNpcs), Attitude.HOSTILE);
                addRandomNpcs((int) (0.5 * friendlyNpcs), Attitude.FRIENDLY);
                break;
        }
    }

    void addRandomNpcs(int numNpcs, Attitude attitude) {
        for (int i = 0; i < numNpcs; i++) {
            builder.setAttitudeTowardsPlayer(attitude).build();
        }
    }

    private Random rand = new Random();
    private Level level;
    private NonPlayerCharacterBuilder builder;
}
