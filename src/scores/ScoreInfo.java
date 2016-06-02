package scores;

import java.io.Serializable;

/**
 * Class represent a score.
 *
 * @author Raziel Solomon
 * @since 01-Jun-16.
 */
public class ScoreInfo implements Serializable {
    private String name;
    private int score;

    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ScoreInfo scoreInfo = (ScoreInfo) o;

        return score == scoreInfo.score && (name != null ? name.equals(scoreInfo.name) : scoreInfo.name == null);
    }

    @Override
    public String toString() {
        return "S{" + name + ", " + score + '}';
    }
}
