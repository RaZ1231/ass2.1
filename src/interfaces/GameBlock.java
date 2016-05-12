package interfaces;

import Animations.GameLevel;

/**
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public interface GameBlock extends HitNotifier, Collidable, Sprite {
    void removeFromGame(GameLevel gameLevel);
}
