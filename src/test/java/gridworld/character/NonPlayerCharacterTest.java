package gridworld.character;

import gridworld.core.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

class NonPlayerCharacterTest {

    @Test
    void tick_callsBehavior() {
        unit.tick();

        assertThat(behavior.wasTickCalled, is(true));
        assertThat(behavior.wasGetCommandsForCurrentTurnCalled, is(false));
    }

    @Test
    void getCommandsForCurrentTurn() {
        List<Command> commands = unit.getCommandsForCurrentTurn(level);

        assertThat(commands, empty());
        assertThat(behavior.wasTickCalled, is(false));
        assertThat(behavior.wasGetCommandsForCurrentTurnCalled, is(true));
    }

    private final LevelFactory levelFactory =
            new LevelFactory(new LevelPopulationStrategySpy());
    private final Level level =
            levelFactory.createLevel(Difficulty.MEDIUM, 8, 4);
    private final BehaviorSpy behavior = new BehaviorSpy();
    private final NonPlayerCharacterBuilder builder =
            new NonPlayerCharacterBuilder(level, behavior);
    private final NonPlayerCharacter unit = builder.build();
}