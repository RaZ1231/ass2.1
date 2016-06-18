package spaceinvaders;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.HitListener;
import interfaces.Sprite;
import motion.Velocity;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class Formation implements Sprite {
    private List<Invader> invaders;
    private Velocity initialV;
    private Acceleration a;
    private int width;
    private int height;
    private Timer time;
    private GameLevel gameLevel;

    public Formation(List<Invader> invaders, Acceleration a, int width, int height) {
        this.a = a;
        this.initialV = a.getV();
        this.invaders = invaders;
        this.width = width;
        this.height = height;
        this.time = new Timer(0);

        initInvaders();
    }

    private void initInvaders() {
        for (Invader invader : invaders) {
            invader.setFormation(this);
            invader.setAccel(a);
        }
    }

    public List<Invader> getInvaders() {
        return invaders;
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
        if (size() > 0) {
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

            if ((leftest.getX() <= 0) || (rightest.getX() + rightest.getWidth() >= width)) {
                stepDown();
                a.flipV();
                a.accelBy(15);
            }

            time.timePassed(dt);
            shoot();
        }
    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        this.gameLevel = gameLevel;

        for (Invader invader : invaders) {
            invader.addToGame(gameLevel);
        }
    }

    public int size() {
        return invaders.size();
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

    public void shoot() {
        if (time.hasPassed()) {
            getShooter().shoot(gameLevel);
            time = new Timer(0.5);
        }
    }

    private Invader getShooter() {
        List<Invader> lowest = getLowestList();
        Random rand = new Random();
        int i = rand.nextInt(lowest.size());

        return lowest.get(i);
    }

    protected List<Invader> getLowestList() {
        List<Invader> lowestList = new LinkedList<>();
        boolean isNewCol;

        for (Invader invader : invaders) {
            isNewCol = true;

            for (int i = 0; i < lowestList.size(); i++) {
                if (invader.getX() == lowestList.get(i).getX()) {
                    isNewCol = false;
                    if (invader.getY() > lowestList.get(i).getY()) {
                        lowestList.set(i, invader);
                    }
                    break;
                }
            }

            if (isNewCol) {
                lowestList.add(invader);
            }
        }

        return lowestList;
    }

    public void move(double dt) {
        for (Invader invader : invaders) {
            invader.timePassed(dt);
        }
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

    public void reset() {
        a.setV(initialV);

        for (Invader invader : invaders) {
            invader.reset();
        }
    }

    public void remove(Invader invader) {
        invaders.remove(invader);
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
