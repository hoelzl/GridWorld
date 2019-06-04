package gridworld.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LevelTest {


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