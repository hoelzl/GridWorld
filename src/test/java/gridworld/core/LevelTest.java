package gridworld.core;

import gridworld.character.AbstractCharacter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LevelTest {

    @Test
    void noteCharacterMove() {
        GameCharacter testCharacter =
                new AbstractCharacter("test character", unit.get(0, 0)) {
                };
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

    private Level unit = new Level(12, 8);
}