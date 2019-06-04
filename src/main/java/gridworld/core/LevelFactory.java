package gridworld.core;

import java.util.Collections;
import java.util.List;

public class LevelFactory {
    public LevelFactory(LevelPopulationStrategy populationStrategy) {
        this.populationStrategy = populationStrategy;
    }

    public Level createLevel(Difficulty difficulty, int width, int height) {
        return createLevel(difficulty, width, height, Collections.emptyList());
    }

    public Level createLevel(Difficulty difficulty, int width, int height,
                             List<CharacterObserver> observers) {
        Level level = new Level(width, height);
        level.registerAll(observers);
        populationStrategy.populateLevel(level, difficulty);
        return level;
    }

    private LevelPopulationStrategy populationStrategy;
}
