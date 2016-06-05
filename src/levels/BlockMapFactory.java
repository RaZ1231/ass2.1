package levels;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class BlockMapFactory {
    public Map<String, String> createMap(String path) {
        Map<String, String> blocksMap = new HashMap<>();

        String ignoredLines = "(\\s)*|(#.*)";
        String defaultLines = "default{1} .*:{1}.*";
        String bdef = "bdef{1} symbol:(1) ((.*:{1}.*)\\s)*";
        String sdef = "sdef{1}\\s((symbol:){1}(1))\\s((width:){1}(2))";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            Pattern pattern = Pattern.compile("");
            Matcher matcher = pattern.matcher("");
            while (br.readLine() != null) {


            }
        } catch (IOException e) {

        }

        return blocksMap;
    }
}
