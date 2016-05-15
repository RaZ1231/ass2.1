package graphics;

import Animations.GameLevel;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class GameFlow {
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {

    }

    public void runLevels(List<LevelInformation> levels) {
        //....
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
