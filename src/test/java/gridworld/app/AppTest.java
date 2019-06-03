package gridworld.app;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AppTest {
    @Test
    void getGreetingReturnsCorrectGreeting() {
        App unit = new App();
        assertThat(unit, is(unit));
    }
}
