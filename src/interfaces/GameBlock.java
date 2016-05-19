package interfaces;

import Animations.GameLevel;

/**
 * game block interface.
 *
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public interface GameBlock extends HitNotifier, Collidable, Sprite {
    /**
     * remove block from game.
     *
     * @param gameLevel a level.
     */
    void removeFromGame(GameLevel gameLevel);
}
