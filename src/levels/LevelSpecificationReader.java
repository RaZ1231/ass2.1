package levels;

import interfaces.LevelInformation;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import utils.Parser;

/**
 * Level reader class.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class LevelSpecificationReader {
    /**
     * use reader to read levels from file.
     *
     * @param reader reader to use
     * @return list of levels.
     */
    public List<LevelInformation> fromReader(java.io.Reader reader) {
        List<LevelInformation> levelI = new LinkedList<>();

        String s = "";
        char c;
        try {
            do {
                c = (char) reader.read();
                s = s + c;
            } while (c != (char) -1);
            reader.close();

            Parser parser = new Parser();
            List<String> stringLevels = parser.parseString(s, "START_LEVEL(.|\\s)*?END_LEVEL");
            LevelFactory factory = new LevelFactory();

            for (String str : stringLevels) {
                levelI.add(factory.create(str));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return levelI;
    }
}
