package levels;

import interfaces.LevelInformation;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

            Executer exe = new Executer();
            exe.createLevel(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return levelI;
    }
}
