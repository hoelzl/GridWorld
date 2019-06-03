package gridworld.core;

import gridworld.behaviors.Behavior_MoveRandomly;
import gridworld.level.LevelPopulationStrategy_LeaveLevelEmpty;

import java.lang.reflect.Constructor;

public class LevelFactory {
    public LevelFactory(LevelPopulationStrategy populationStrategy) {
        this.populationStrategy = populationStrategy;
    }

    public LevelFactory(
            Class<? extends LevelPopulationStrategy> levelPopulationStrategyClass) {
        this.levelPopulationStrategyClass = levelPopulationStrategyClass;
    }

    public Level createLevel(Difficulty difficulty, int width, int height) {
        var level = new Level(width, height);
        try {
            Constructor<? extends LevelPopulationStrategy> constructor =
                    levelPopulationStrategyClass.getConstructor(Level.class,
                            Behavior.class);
            populationStrategy =
                    constructor.newInstance(level, new Behavior_MoveRandomly());
        } catch (Exception ex) {
            this.populationStrategy =
                    new LevelPopulationStrategy_LeaveLevelEmpty();
            throw new RuntimeException(ex);
        }

        populationStrategy.populateLevel(difficulty);
        return level;
    }

    private Class<? extends LevelPopulationStrategy>
            levelPopulationStrategyClass;
    private LevelPopulationStrategy populationStrategy;
}
