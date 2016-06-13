package levels;

import interfaces.BlockCreator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Parser;

/**
 * Blocks definition reader class.
 *
 * @author Elisheva Broyer.
 * @since 06/06/2016.
 */
public class BlocksDefinitionReader {
    /**
     * get factory from reader.
     *
     * @param reader reader with path
     * @return blocks factory
     */
    public static BlocksFromSymbolsFactory fromReader(java.io.Reader reader) {
        BlocksFromSymbolsFactory bFSF = new BlocksFromSymbolsFactory();
        Map<String, Integer> spacerWidths = new HashMap<>();
        Map<String, BlockCreator> blockCreators = new HashMap<>();
        Map<String, String> defaultS = new HashMap<>();
        Parser parser = new Parser();

        String defaultLines = "default (.*:.*)+";
        String bdef = "bdef symbol:(.) (.*:.*)*";
        String sdef = "sdef symbol:(.) width:(.*)";

        String s = "";
        char c;
        try {
            do {
                c = (char) reader.read();
                s = s + c;
            } while (c != (char) -1);
            reader.close();

            String defaultString = parser.getString(s, defaultLines);
            List<String> defaults = new ArrayList<>();

            if (!defaultString.equals("")) {
                defaults = Arrays.asList(defaultString.substring(8).split(" "));
            }
            BlockCreator defaultCreator = getBlockCreator(defaults, new ContainerBlock());

            //creating map of block creators.
            List<String> bdefs = parser.parseString(s, bdef);
            for (String line : bdefs) {
                String[] split = line.split(" ");
                BlockCreator blockCreator = getBlockCreator(Arrays.asList(split).subList(1, split.length),
                        ContainerBlock.fromBlock(defaultCreator.create(0, 0)));
                blockCreators.put(split[1].split(":")[1], blockCreator);
            }

            //creating map of width spacers.
            List<String> sdefs = parser.parseString(s, sdef);
            for (String str : sdefs) {
                String key = parser.getString(str, "symbol:(.)").split(":")[1];
                int value = Integer.parseInt(parser.getString(str, "width:(\\d*)").split(":")[1]);
                spacerWidths.put(key, value);
            }

            bFSF.setSpacerWidths(spacerWidths);
            bFSF.setBlockCreators(blockCreators);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bFSF;
    }

    /**
     * creates block creator.
     *
     * @param specifics to create by.
     * @param defaultCB default specifics.
     * @return block creator
     */
    private static BlockCreator getBlockCreator(List<String> specifics, ContainerBlock defaultCB) {
        Parser parser = new Parser();
        String[] split;
        TextEnumHelper helper = new TextEnumHelper();

        for (String specific : specifics) {
            split = parser.getString(specific, "\\w*:[\\S]*").split(":");

            if (split[0].matches("\\d*")) { //fill-k
                int k = Integer.parseInt(split[0]);
                defaultCB.putFillK(k, FillParser.fromString(
                        split[1].substring(6, split[1].length() - 1)));
            } else {
                BlockSpec spec = (BlockSpec) helper.valueOfText(BlockSpec.values(), split[0]);
                spec.setBlock(defaultCB, split[1]);
            }
        }

        return BlockCreatorFactory.fromContainer(defaultCB);
    }
}
