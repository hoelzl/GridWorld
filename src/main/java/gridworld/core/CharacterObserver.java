package gridworld.core;

public interface CharacterObserver {
    // Careful: character is not completely intialized here!
    void onCharacterCreation(CharacterInterface character);

    void onCharacterMove(CharacterInterface character, Location newLocation);

    void onCharacterDeath(CharacterInterface character);
}
