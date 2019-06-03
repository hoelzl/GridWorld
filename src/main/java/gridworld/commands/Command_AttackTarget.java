package gridworld.commands;

import gridworld.character.Character;
import gridworld.core.Command;

public class Command_AttackTarget implements Command {
    public Command_AttackTarget(Character character, Character targetToAttack) {
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

    private Character character;
    private Character targetToAttack;
}
