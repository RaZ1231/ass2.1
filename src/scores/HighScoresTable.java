package scores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Class deals with high scores table, reading and writing to file.
 *
 * @author Raziel Solomon
 * @since 01-Jun-16.
 */
public class HighScoresTable implements Serializable {
    private List<ScoreInfo> scores;
    private int size;

    /**
     * Create an empty high-scores table with the specified size.
     * The size means that the table holds up to size top scores.
     *
     * @param size size of table.
     */
    public HighScoresTable(int size) {
        scores = new LinkedList<ScoreInfo>();
        this.size = size;
    }

    /**
     * Read a table from file and return it.
     * If the file does not exist, or there is a problem with
     * reading it, an empty table is returned.
     *
     * @param filename path.
     * @return high scores table.
     */
    public static HighScoresTable loadFromFile(File filename) {
        HighScoresTable highScores = new HighScoresTable(5);

        try {
            highScores.load(filename);
        } catch (IOException e) {
            try {
                highScores.save(filename);
            } catch (IOException e1) {
                System.out.println("problem saving scores!");
            }
        }

        return highScores;
    }

    /**
     * Load table data from file.
     * Current table data is cleared.
     *
     * @param filename path.
     * @throws IOException an exception.
     */
    public void load(File filename) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            size = (int) objectInputStream.readObject();
            try {
                scores = (List<ScoreInfo>) objectInputStream.readObject();
            } catch (Exception e) {
                System.out.println("problem loading scores!");
            }
        } catch (ClassNotFoundException e) {
            scores = new LinkedList<ScoreInfo>();
        }
    }

    /**
     * Save table data to the specified file.
     *
     * @param filename path.
     * @throws IOException an exception.
     */
    public void save(File filename) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(size);
            objectOutputStream.writeObject(scores);
        }
    }

    /**
     * Add a high-score.
     *
     * @param score new score.
     */
    public void add(ScoreInfo score) {
        int i = getRank(score.getScore());

        if (i <= size()) {
            scores.add(i - 1, score);
        }
        if (scores.size() > size()) {
            scores.remove(size());
        }
    }

    /**
     * return the rank of the current score: where will it
     * be on the list if added?
     * Rank 1 means the score will be highest on the list.
     * Rank `size` means the score will be lowest.
     * Rank > `size` means the score is too low and will not
     * be added to the list.
     *
     * @param score score to check.
     * @return rank in table.
     */
    public int getRank(int score) {
        int i = 1;

        while ((i <= scores.size()) && (score <= scores.get(i - 1).getScore())) {
            i++;
        }

        return i;
    }

    /**
     * Return table size.
     *
     * @return size.
     */
    public int size() {
        return size;
    }

    //
    //
    //

    /**
     * Return the current high scores.
     * The list is sorted such that the highest
     * scores come first.
     *
     * @return high scores.
     */
    public List<ScoreInfo> getHighScores() {
        return scores;
    }

    /**
     * check if score in table.
     *
     * @param score to check.
     * @return true/false.
     */
    public boolean checkScore(int score) {
        return getRank(score) <= size();
    }

    /**
     * Clears the table.
     */
    public void clear() {
        scores = new LinkedList<ScoreInfo>();
    }

    /**
     * get ith score.
     *
     * @param i index in list.
     * @return ith score.
     */
    public ScoreInfo get(int i) {
        return scores.get(i);
    }

    /**
     * get score list size.
     *
     * @return size.
     */
    public int numOfScores() {
        return scores.size();
    }

    /**
     * equals method.
     *
     * @param o other object.
     * @return true/false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HighScoresTable table = (HighScoresTable) o;

        return size == table.size && (scores != null ? scores.equals(table.scores) : table.scores == null);

    }

    /**
     * toString method.
     *
     * @return string representation.
     */
    @Override
    public String toString() {
        return "HS{" + size + ", " + scores + '}';
    }
}
