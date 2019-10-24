package gridworld.commands;

import gridworld.character.AbstractCharacter;
import gridworld.core.Command;

public class Command_AttackTarget implements Command {
    public Command_AttackTarget(AbstractCharacter character, AbstractCharacter targetToAttack) {
        this.character = character;
        this.targetToAttack = targetToAttack;
    }

    @Override
    public void execute() {
        character.attack(targetToAttack);
    }

    @Override
    public String getDescription() {
        return null;
    }

    private AbstractCharacter character;
    private AbstractCharacter targetToAttack;
}
