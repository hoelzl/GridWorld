package gridworld.character;

import gridworld.core.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AbstractCharacterTest {

    @Test
    void constructor_triggersObserverUpdate() {
        CharacterObserverSpy observer = new CharacterObserverSpy();
        level.register(observer);

        unit = new TestCharacter("Test Character", level.get(3, 4));

        assertThat(observer.wasOnCharacterCreationCalled, is(true));
        assertThat(observer.wasOnCharacterMoveCalled, is(false));
        assertThat(observer.wasOnCharacterDeathCalled, is(false));
        assertThat(observer.character, is(unit));
    }


    @Test
    void constructor_addsCharacterToLevel() {
        assertThat(level.getCharacters(), hasItem(unit));
    }


    @Test
    void die_triggersObserverUpdate() {
        CharacterObserverSpy observer = new CharacterObserverSpy();
        level.register(observer);

        unit.die();

        assertThat(observer.wasOnCharacterCreationCalled, is(false));
        assertThat(observer.wasOnCharacterMoveCalled, is(false));
        assertThat(observer.wasOnCharacterDeathCalled, is(true));
        assertThat(observer.character, is(unit));
    }


    @Test
    void die_removesCharacterFromLevel() {
        unit.die();

        assertThat(level.getCharacters(), not(hasItem(unit)));
    }


    @Test
    void getLocation() {
        assertThat(unit.getLocation(), is(level.get(initialW, initialH)));
    }

    @Test
    void move_setsCharacterLocationCorrectly() {
        unit.move(Direction.NORTH);
        assertThat(unit.getLocation(), is(level.get(initialW, initialH + 1)));
    }

    @Test
    void move_triggersObserverUpdate() {
        CharacterObserverSpy observer = new CharacterObserverSpy();
        level.register(observer);

        unit.move(Direction.NORTH);

        assertThat(observer.wasOnCharacterCreationCalled, is(false));
        assertThat(observer.wasOnCharacterMoveCalled, is(true));
        assertThat(observer.wasOnCharacterDeathCalled, is(false));
        assertThat(observer.character, is(unit));
    }

    private final int initialW = 2;
    private final int initialH = 3;

    private Level level =
            new LevelFactory(new LevelPopulationStrategySpy()).createLevel(
                    Difficulty.MEDIUM, 12, 8);
    private AbstractCharacter unit =
            new TestCharacter("Test Character", level.get(initialW, initialH));
}
