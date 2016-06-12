package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A regex wrapper class.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Parser {
    /**
     * get list of strings that matches the pattern.
     *
     * @param s             text
     * @param patternString pattern
     * @return list
     */
    public List<String> parseString(String s, String patternString) {
        List<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            list.add(s.substring(matcher.start(), matcher.end()));
        }

        return list;
    }

    /**
     * get string that matches the pattern.
     *
     * @param s             text
     * @param patternString pattern
     * @return string
     */
    public String getString(String s, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);
        String ans = "";

        if (matcher.find()) {
            ans = s.substring(matcher.start(), matcher.end());
        }

        return ans;
    }

    /**
     * get string that matches the pattern in the ith capturing group.
     *
     * @param s             text
     * @param patternString pattern
     * @param i             cap group number
     * @return string
     */
    public String getString(String s, String patternString, int i) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);
        String ans = "";

        if (matcher.find()) {
            ans = matcher.group(i);
        }

        return ans;
    }

}
