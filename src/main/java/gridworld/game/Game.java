package gridworld.game;

import gridworld.behaviors.Behavior_MoveRandomly;
import gridworld.character.Player;
import gridworld.core.Difficulty;
import gridworld.core.Level;
import gridworld.core.LevelFactory;
import gridworld.level.LevelPopulationStrategy_DistributeRandomElements;

public class Game {

    public Game(Difficulty difficulty) {
        this.difficulty = difficulty;

        var behvior = new Behavior_MoveRandomly();
        var levelFactory = new LevelFactory(
                LevelPopulationStrategy_DistributeRandomElements.class);
        level = levelFactory.createLevel(difficulty, 12, 10);
    }

    private Level level;
    private Player player;
    private Difficulty difficulty;
}
