package interfaces;

import game.Game;

/**
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public interface InterBlock extends HitNotifier, Collidable, Sprite {
    void removeFromGame(Game game);
}
