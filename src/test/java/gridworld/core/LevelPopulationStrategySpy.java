package gridworld.core;

public class LevelPopulationStrategySpy implements LevelPopulationStrategy {
    @Override
    public void populateLevel(Difficulty difficulty) {
        wasPopulateLevelCalled = true;
    }

    boolean wasPopulateLevelCalled = false;
}
