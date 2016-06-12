package levels;

import interfaces.Fill;
import sprites.FillColor;
import sprites.FillImage;

import java.awt.Color;

/**
 * Fill parser class.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public class FillParser {
    /**
     * parse fill from string.
     *
     * @param s string
     * @return a fill object
     */
    public static Fill fromString(String s) {
        switch (s) {
            case "black":
                return new FillColor(Color.black);
            case "blue":
                return new FillColor(Color.blue);
            case "cyan":
                return new FillColor(Color.cyan);
            case "gray":
                return new FillColor(Color.gray);
            case "lightGray":
                return new FillColor(Color.lightGray);
            case "green":
                return new FillColor(Color.green);
            case "orange":
                return new FillColor(Color.orange);
            case "pink":
                return new FillColor(Color.pink);
            case "red":
                return new FillColor(Color.red);
            case "white":
                return new FillColor(Color.white);
            case "yellow":
                return new FillColor(Color.yellow);
            default:// RGB or image.
                if (s.substring(0, 3).equals("RGB")) {
                    String str = s.substring(4, s.length() - 1);//RGB(x,y,z)
                    String[] out = str.split(",");
                    return new FillColor(new Color(Integer.parseInt(out[0]),
                            Integer.parseInt(out[1]), Integer.parseInt(out[2])));
                } else {
                    return new FillImage(s);
                }
        }
    }
}
