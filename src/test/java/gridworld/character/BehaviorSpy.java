package gridworld.character;

import gridworld.core.Behavior;
import gridworld.core.Command;
import gridworld.core.Level;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class BehaviorSpy implements Behavior {
    @Override
    public List<Command> getCommandsForCurrentTurn(NonPlayerCharacter character,
                                                   Level level) {
        wasGetCommandsForCurrentTurnCalled = true;
        return Collections.emptyList();
    }

    @Override
    public void tick(NonPlayerCharacter nonPlayerCharacter, Level level) {
        wasTickCalled = true;
    }

    public boolean wasGetCommandsForCurrentTurnCalled = false;
    public boolean wasTickCalled = false;
}
