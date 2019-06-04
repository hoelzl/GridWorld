package gridworld.core;

public class CharacterObserverSpy implements CharacterObserver {
    @Override
    public void onCharacterCreation(GameCharacter character) {
        this.character = character;
        this.wasOnCharacterCreationCalled = true;
    }

    @Override
    public void onCharacterMove(GameCharacter character, Location newLocation) {
        this.character = character;
        this.newLocation = newLocation;
        this.wasOnCharacterMoveCalled = true;
    }

    @Override
    public void onCharacterDeath(GameCharacter character) {
        this.character = character;
        this.wasOnCharacterDeathCalled = true;
    }

    public boolean wasOnCharacterCreationCalled = false;
    public boolean wasOnCharacterMoveCalled = false;
    public boolean wasOnCharacterDeathCalled = false;
    public GameCharacter character;
    public Location newLocation;
}
