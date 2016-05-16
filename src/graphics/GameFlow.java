package graphics;

import Animations.GameLevel;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collisions.GameEnvironment;
import interfaces.LevelInformation;
import java.util.List;
import utils.Counter;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter score;
    private Counter lives;
    private GameEnvironment environment;
    private GUI gui;


    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
    }

    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo);//, this.keyboardSensor, this.animationRunner);

            level.initialize();

            while ((level.getBlocksCounter().getValue() > 0) && (level.getLives().getValue() > 0)) {
                level.playOneTurn();
            }

            if (level.getLives().getValue() == 0) {
                break;
            }

        }
    }
}
