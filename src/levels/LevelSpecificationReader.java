package levels;

import interfaces.LevelInformation;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import utils.Parser;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class LevelSpecificationReader {
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

            for (String str : stringLevels) {
                Executor exe = new Executor();
                levelI.add(exe.createLevel(str));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return levelI;
    }
}
