package gridworld.core;

import gridworld.character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Level {
    Level(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new ArrayList<>();
        for (int i = 0; i < width * height; i++) {
            board.add(new Location(this));
        }
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                get(w, h).setW(w);
                get(w, h).setH(h);
                computeNeighborsForLocationAt(w, h);
            }
        }
    }

    public void register(CharacterObserver observer) {
        characterObservers.add(observer);
    }

    @SuppressWarnings("WeakerAccess")
    public void registerAll(List<CharacterObserver> observers) {
        characterObservers.addAll(observers);
    }

    public void unregister(CharacterObserver observer) {
        characterObservers.remove(observer);
    }

    public void noteCharacterCreation(Character character) {
        assert character != null;
        addCharacter(character);
        for (CharacterObserver observer : characterObservers) {
            observer.onCharacterCreation(character);
        }
    }

    public void noteCharacterMove(Character character, Location newLocation) {
        assert character != null;
        assert newLocation != null;

        for (CharacterObserver observer : characterObservers) {
            observer.onCharacterMove(character, newLocation);
        }
    }

    public void noteCharacterDeath(Character character) {
        assert character != null;
        for (CharacterObserver observer : characterObservers) {
            observer.onCharacterDeath(character);
        }
        removeCharacter(character);
    }

    private void computeNeighborsForLocationAt(int w, int h) {
        computeNeighbor(Direction.NORTH, w, h, () -> h < height - 1,
                () -> get(w, h + 1));
        computeNeighbor(Direction.EAST, w, h, () -> w < width - 1,
                () -> get(w + 1, h));
        computeNeighbor(Direction.SOUTH, w, h, () -> h > 0, () -> get(w, h - 1));
        computeNeighbor(Direction.WEST, w, h, () -> w > 0, () -> get(w - 1, h));
    }

    private void computeNeighbor(Direction direction, int w, int h, Supplier<Boolean> test,
                                 Supplier<Location> neighbor) {
        Location location = get(w, h);
        if (test.get()) {
            location.setNeighbor(direction, neighbor.get());
        } else {
            location.setNeighbor(direction, location);
        }
    }

    public Location get(int w, int h) {
        assert w < width;
        assert h < height;
        return board.get(w + h * width);
    }

    public int size() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void addCharacter(Character character) {
        characters.add(character);
    }

    private void removeCharacter(Character character) {
        characters.remove(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    private int width;
    private int height;
    private List<Location> board;
    private List<Character> characters = new ArrayList<>();
    private List<CharacterObserver> characterObservers = new ArrayList<>();
}
