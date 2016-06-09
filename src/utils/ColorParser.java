package utils;

import java.awt.Color;

/**
 * @author Elisheva Broyer.
 * @since 08/06/2016.
 */
public class ColorParser {
    // parse color definition and return the specified color.
    public java.awt.Color colorFromString(String s) {
        switch (s) {
            case "black":
                return Color.black;
            case "blue":
                return Color.blue;
            case "cyan":
                return Color.cyan;
            case "gray":
                return Color.gray;
            case "lightGray":
                return Color.lightGray;
            case "green":
                return Color.green;
            case "orange":
                return Color.orange;
            case "pink":
                return Color.pink;
            case "red":
                return Color.red;
            case "white":
                return Color.white;
            case "yellow":
                return Color.yellow;
            default:// color defined by RGB.
                String str = s.substring(4, s.length());//RGB(x,y,z)
                String[] out = str.split(",");
                return new Color(Integer.parseInt(out[0]),
                        Integer.parseInt(out[1]), Integer.parseInt(out[2]));
        }
    }
}
