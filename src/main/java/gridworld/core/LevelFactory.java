package gridworld.core;

public class LevelFactory {
    public LevelFactory(LevelPopulationStrategy populationStrategy) {
        this.populationStrategy = populationStrategy;
    }

    public Level createLevel(Difficulty difficulty, int width, int height) {
        var level = new Level(width, height);
        populationStrategy.populateLevel(difficulty);
        return level;
    }

    private LevelPopulationStrategy populationStrategy;
}
