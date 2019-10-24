package gridworld.game;

import gridworld.behaviors.Behavior_MoveRandomly;
import gridworld.character.Character;
import gridworld.character.Player;
import gridworld.core.*;
import gridworld.level.LevelPopulationStrategy_DistributeRandomElements;

import java.util.List;

public class Game {
    public Game(Difficulty difficulty, int width, int height,
                List<CharacterObserver> observers) {
        Behavior behavior = new Behavior_MoveRandomly();
        LevelPopulationStrategy populationStrategy =
                new LevelPopulationStrategy_DistributeRandomElements(behavior);
        LevelFactory levelFactory = new LevelFactory(populationStrategy);
        level = levelFactory.createLevel(difficulty, width, height, observers);
        player = new Player("Player", level.get(1, 1));
    }

    public void tick() {
        numTicks++;
        for (CharacterInterface character : level.getCharacters()) {
            character.tick();
        }
        if (numTicks > 5) {
            finished = true;
        }
    }

    public Level getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isFinished() {
        return finished;
    }

    private Level level;
    private Player player;
    private int numTicks = 0;
    private boolean finished = false;
}
