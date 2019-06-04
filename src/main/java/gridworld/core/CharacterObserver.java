package gridworld.core;

public interface CharacterObserver {
    void onCharacterCreation(GameCharacter character);

    void onCharacterMove(GameCharacter character, Location newLocation);

    void onCharacterDeath(GameCharacter character);
}
