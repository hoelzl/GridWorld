package gridworld.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LevelFactoryTest {

    @Test
    void createLevel_createsLevelWithCorrectDimensions() {
        var level = unit.createLevel(Difficulty.MEDIUM, 10, 6);

        assertThat(level.getWidth(), is(10));
        assertThat(level.getHeight(), is(6));
    }

    @Test
    void createLevel_callsLevelPopulationStrategy() {
        unit.createLevel(Difficulty.MEDIUM, 10, 6);

        assertThat(populationStrategy.wasPopulateLevelCalled, is(true));
    }

    private LevelPopulationStrategySpy populationStrategy =
            new LevelPopulationStrategySpy();
    private LevelFactory unit = new LevelFactory(populationStrategy);

}