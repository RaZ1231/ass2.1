package game;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * high scores' table class.
 *
 * @author Elisheva Broyer.
 * @since 31/05/2016.
 */
public class HighScoresTable {
    /**
     * Create an empty high-scores table with the specified size.
     * The size means that the table holds up to size top scores.
     *
     * @param size table's size.
     */
    public HighScoresTable(int size) {

    }

    /**
     * Read a table from file and return it.
     * If the file does not exist, or there is a problem with
     * reading it, an empty table is returned.
     *
     * @param filename a file to read from.
     * @return a table from file.
     */
    public static HighScoresTable loadFromFile(File filename) {
        return null;
    }

    /**
     * Add a high-score.
     *
     * @param score player's score.
     */
    public void add(ScoreInfo score) {
    }

    /**
     * Returns table size.
     *
     * @return table size.
     */
    public int size() {
        return 0;
    }

    /**
     * Return the current high scores.
     * The list is sorted such that the highest scores come first.
     *
     * @return the current high scores.
     */
    public List<ScoreInfo> getHighScores() {
        return null;
    }

    /**
     * returns the rank of the current score: where will it
     * be on the list if added?
     * Rank 1 means the score will be highest on the list.
     * Rank `size` means the score will be lowest.
     * Rank > `size` means the score is too low and will not be added to the list.
     *
     * @param score player's score.
     * @return the rank of the current score
     */
    public int getRank(int score) {
        return 0;
    }

    /**
     * Clears the table.
     */
    public void clear() {
    }

    /**
     * Load table data from file.
     * Current table data is cleared.
     *
     * @param filename a file to read from.
     * @throws IOException exception in reading.
     */
    public void load(File filename) throws IOException {
    }

    /**
     * Save table data to the specified file.
     *
     * @param filename a file to write in.
     * @throws IOException exception in writing.
     */
    public void save(File filename) throws IOException {
    }
}
