package gridworld.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LocationTest {

    @Test
    void neighbors_forInternalLocation() {
        Location unit = level.get(1, 1);

        assertThat(unit.getNeighbor(Direction.NORTH), is(level.get(1, 2)));
        assertThat(unit.getNeighbor(Direction.EAST), is(level.get(2, 1)));
        assertThat(unit.getNeighbor(Direction.SOUTH), is(level.get(1, 0)));
        assertThat(unit.getNeighbor(Direction.WEST), is(level.get(0, 1)));
    }

    @Test
    void neighbors_forBorderLocation() {
        Location unit = level.get(11, 1);

        assertThat(unit.getNeighbor(Direction.NORTH), is(level.get(11, 2)));
        assertThat(unit.getNeighbor(Direction.EAST), is(level.get(11, 1)));
        assertThat(unit.getNeighbor(Direction.SOUTH), is(level.get(11, 0)));
        assertThat(unit.getNeighbor(Direction.WEST), is(level.get(10, 1)));
    }

    @Test
    void neighbors_forCornerLocation() {
        Location unit = level.get(0, 7);

        assertThat(unit.getNeighbor(Direction.NORTH), is(level.get(0, 7)));
        assertThat(unit.getNeighbor(Direction.EAST), is(level.get(1, 7)));
        assertThat(unit.getNeighbor(Direction.SOUTH), is(level.get(0, 6)));
        assertThat(unit.getNeighbor(Direction.WEST), is(level.get(0, 7)));
    }

    private Level level = new Level(12, 8);
}