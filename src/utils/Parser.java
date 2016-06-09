package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Parser {
    public List<String> parseString(String s, String patternString) {
        List<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            list.add(s.substring(matcher.start(), matcher.end()));
        }

        return list;
    }

    public String getString(String s, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            return s.substring(matcher.start(), matcher.end());
        }
        return "";
    }

}
