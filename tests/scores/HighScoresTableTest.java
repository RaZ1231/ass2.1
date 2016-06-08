package scores;

import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Raziel Solomon
 * @since 01-Jun-16.
 */
public class HighScoresTableTest {
    @Test
    public void load() throws Exception {
        String path = "highscores.ser";
        HighScoresTable expected = new HighScoresTable(5);

        expected.add(new ScoreInfo("Nevo", -15));
        expected.add(new ScoreInfo("Raz", 9999));
        expected.add(new ScoreInfo("Maayan", 34));
        expected.add(new ScoreInfo("Elish", 999999999));

        expected.save(new File(path));
        HighScoresTable actual = HighScoresTable.loadFromFile(new File(path));

        System.out.println(actual);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void save() throws Exception {
        String path = "highscores.ser";
        HighScoresTable highScores = new HighScoresTable(5);

        highScores.add(new ScoreInfo("Raz", 99999));
        highScores.add(new ScoreInfo("Elish", 99999999));
        highScores.add(new ScoreInfo("Maayan", 34));
        highScores.add(new ScoreInfo("Nevo", -15));

        highScores.save(new File(path));
    }

}