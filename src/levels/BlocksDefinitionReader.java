package levels;

import blocks.Block;
import interfaces.BlockCreator;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shapes.Point;
import shapes.Rectangle;
import utils.Parser;

/**
 * @author Elisheva Broyer.
 * @since 06/06/2016.
 */
public class BlocksDefinitionReader {
    public static BlocksFromSymbolsFactory fromReader(java.io.Reader reader) {
        BlocksFromSymbolsFactory bFSF = new BlocksFromSymbolsFactory();
        Map<String, Integer> spacerWidths = new HashMap<>();
        Map<String, BlockCreator> blockCreators = new HashMap<>();

        String defaultLines = "default{1} .*:{1}.*";
        String bdef = "bdef{1} symbol:{1}(.) (.*:.*)*";
        String sdef = "sdef{1} symbol:{1}(.) width:{1}(.*)";

        String s = "";
        char c;
        try {
            do {
                c = (char) reader.read();
                s = s + c;
            } while (c != (char) -1);
            reader.close();

            Parser parser = new Parser();
            List<String> defaults = parser.parseString(s, defaultLines);
            List<String> bdefs = parser.parseString(s, bdef);
            List<String> sdefs = parser.parseString(s, sdef);

            //create a list of defaults. map?

            //creating map of block creators.
            //while creating the maps, implement the anonymous class.
            String[] out = null;
            for (String str : bdefs) {
                out = parser.getString(str, "symbol:{1}(.)").split(":");
                String symbol = out[1];
                out = parser.getString(str, "height:{1}(.)").split(":");
                final int height = Integer.parseInt(out[1]);
                out = parser.getString(str, "width:{1}(.)").split(":");
                final int width = Integer.parseInt(out[1]);
                out = parser.getString(str, "fill:{1}(.)").split(":");
                String sColor = out[1];
                final Color color = null;
                out = parser.getString(str, "hit_points:{1}(.)").split(":");
                final int hits = Integer.parseInt(out[1]);

                BlockCreator blockCreator = new BlockCreator() {
                    @Override
                    public Block create(int xpos, int ypos) {
                        return new Block(new Rectangle(new Point(xpos, ypos), width, height), color, hits);
                    }
                };
                blockCreators.put(symbol, blockCreator);
            }

            //creating map of width spacers.
            for (String str : sdefs) {
                out = parser.getString(str, "symbol:{1}(.)").split(":");
                String key = out[1];
                out = parser.getString(str, "width:{1}(.)").split(":");
                int value = Integer.parseInt(out[1]);
                spacerWidths.put(key, value);
            }


            bFSF.setSpacerWidths(spacerWidths);
            bFSF.setBlockCreators(blockCreators);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
