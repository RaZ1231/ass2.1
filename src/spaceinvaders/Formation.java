package spaceinvaders;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.HitListener;
import interfaces.Sprite;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class Formation implements Sprite {
    private List<Invader> invaders;
    private Acceleration a;
    private int width;
    private int height;
    private Timer time;
    private GameLevel gameLevel;

    public Formation(List<Invader> invaders, Acceleration a, int width, int height) {
        this.a = a;
        this.invaders = invaders;
        this.width = width;
        this.height = height;
        this.time = new Timer(0);
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        for (Invader invader : invaders) {
            invader.drawOn(d);
        }
    }

    /**
     * notify the sprite that time has passed.
     *
     * @param dt seconds passed.
     */
    @Override
    public void timePassed(double dt) {
        time.timePassed(dt);

        Invader leftest = getMostPos(new PositionCmp() {
            @Override
            public boolean compare(Invader i1, Invader i2) {
                return i1.isLefterThan(i2);
            }
        });

        Invader rightest = getMostPos(new PositionCmp() {
            @Override
            public boolean compare(Invader i1, Invader i2) {
                return i1.isRighterThan(i2);
            }
        });

        if ((leftest.getUpperLeft().getX() <= 0) ||
                (rightest.getUpperLeft().getX() + rightest.getWidth() >= width)) {
            stepDown();
            a.flipV();
            a.accelBy(10);
        }

        move(dt);
    }

    public Invader getMostPos(PositionCmp cmp) {
        Invader biggest = invaders.get(0);

        for (Invader invader : invaders) {
            if (cmp.compare(biggest, invader)) {
                biggest = invader;
            }
        }

        return biggest;
    }

    public void stepDown() {
        for (Invader invader : invaders) {
            invader.stepDown();
        }
    }

    public void move(double dt) {
        for (Invader invader : invaders) {
            invader.timePassed(dt);
        }
    }

    public void shoot() {
        if (time.hasPassed()) {
            getShooter().shoot(gameLevel);
            time = new Timer(0.5);
        }
    }

    private Invader getShooter() {

    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);

        for (Invader invader : invaders) {
            gameLevel.addCollidable(invader);
        }

        this.gameLevel = gameLevel;
    }

    public Invader getLowest() {
        return getMostPos(new PositionCmp() {
            @Override
            public boolean compare(Invader i1, Invader i2) {
                return i1.isLowerThan(i2);
            }
        });
    }

    /**
     * add listener to block's list.
     *
     * @param hl a hit listener.
     */
    public void addHitListener(HitListener hl) {
        for (Invader invader : invaders) {
            invader.addHitListener(hl);
        }
    }

    /**
     * remove listener from block's list.
     *
     * @param hl a hit listener.
     */
    public void removeHitListener(HitListener hl) {
        for (Invader invader : invaders) {
            invader.removeHitListener(hl);
        }
    }

    /**
     * remove block from game.
     *
     * @param gameLevel a level.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}
