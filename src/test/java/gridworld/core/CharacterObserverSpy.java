package gridworld.core;

import gridworld.character.Character;

public class CharacterObserverSpy implements CharacterObserver {
    @Override
    public void onCharacterCreation(CharacterInterface character) {
        this.character = character;
        this.wasOnCharacterCreationCalled = true;
    }

    @Override
    public void onCharacterMove(CharacterInterface character, Location newLocation) {
        this.character = character;
        this.newLocation = newLocation;
        this.wasOnCharacterMoveCalled = true;
    }

    @Override
    public void onCharacterDeath(CharacterInterface character) {
        this.character = character;
        this.wasOnCharacterDeathCalled = true;
    }

    public boolean wasOnCharacterCreationCalled = false;
    public boolean wasOnCharacterMoveCalled = false;
    public boolean wasOnCharacterDeathCalled = false;
    public CharacterInterface character;
    public Location newLocation;
}
