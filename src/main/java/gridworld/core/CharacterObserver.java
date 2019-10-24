package gridworld.core;

public interface CharacterObserver {
    // Careful: character is not completely intialized here!
    void onCharacterCreation(Character character);

    void onCharacterMove(Character character, Location newLocation);

    void onCharacterDeath(Character character);
}
