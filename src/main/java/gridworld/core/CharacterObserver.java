package gridworld.core;

import gridworld.character.Character;

public interface CharacterObserver {
    void onCharacterCreation(Character character);

    void onCharacterMove(Character character, Location newLocation);

    void onCharacterDeath(Character character);
}
