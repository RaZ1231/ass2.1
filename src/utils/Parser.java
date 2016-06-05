package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Parser {
    public String getExpression(String s, int i) {
        String patternString = "level_name:(1)\n" +
                "ball_velocities:(2);\n" +
                "background:(3)\n" +
                "paddle_speed:(4)\n" +
                "paddle_width:(5)\n" +
                "block_definitions:(6)\n" +
                "blocks_start_x:(7)\n" +
                "blocks_start_y:(8)\n" +
                "row_height:(9)\n" +
                "num_blocks:(10)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            return matcher.group(i);
        }
        return null;
    }


}
