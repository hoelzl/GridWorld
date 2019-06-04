package gridworld.core;

public class LevelPopulationStrategySpy implements LevelPopulationStrategy {
    @Override
    public void populateLevel(Level level, Difficulty difficulty) {
        wasPopulateLevelCalled = true;
    }

    boolean wasPopulateLevelCalled = false;
}
