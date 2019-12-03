package gridworld.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LevelTest {

    @Test
    void noteCharacterMove() {
        Character testCharacter = new TestCharacter();
        Location newLocation = unit.get(0, 1);
        CharacterObserverSpy observer = new CharacterObserverSpy();
        unit.register(observer);

        unit.noteCharacterMove(testCharacter, newLocation);

        assertThat(observer.wasOnCharacterCreationCalled, is(false));
        assertThat(observer.wasOnCharacterMoveCalled, is(true));
        assertThat(observer.wasOnCharacterDeathCalled, is(false));
        assertThat(observer.character, is(testCharacter));
        assertThat(observer.newLocation, is(newLocation));
    }

    @Test
    void size() {
        assertThat(unit.size(), is(unit.getWidth() * unit.getHeight()));
    }

    @Test
    void getWidth() {
        assertThat(unit.getWidth(), is(12));
    }

    @Test
    void getHeight() {
        assertThat(unit.getHeight(), is(8));
    }

    @Test
    void get_returnsLocationWithCorrectWAndHIndices() {
        Location l = unit.get(3, 5);
        assertThat(l.getW(), is(3));
        assertThat(l.getH(), is(5));
    }

    private Level unit = new Level(12, 8);
}