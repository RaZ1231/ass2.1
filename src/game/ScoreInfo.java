package game;

import java.io.Serializable;

/**
 * score info class.
 *
 * @author Elisheva Broyer.
 * @since 31/05/2016.
 */
public class ScoreInfo implements Serializable {
    private String name;
    private int score;

    /**
     * constructor.
     *
     * @param name  player's name.
     * @param score player's scores.
     */
    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * returns player's name.
     *
     * @return player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * returns player's scores.
     *
     * @return player's scores.
     */
    public int getScore() {
        return score;
    }
}
