package gridworld.core;

public class LevelFactory {
    public LevelFactory(LevelPopulationStrategy populationStrategy) {
        this.populationStrategy = populationStrategy;
    }

    public Level createLevel(Difficulty difficulty, int width, int height) {
        Level level = new Level(width, height);
        populationStrategy.populateLevel(level, difficulty);
        return level;
    }

    private LevelPopulationStrategy populationStrategy;
}
