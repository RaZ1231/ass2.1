package levels;

import interfaces.LevelInformation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Level sets reader class.
 *
 * @author Raziel Solomon
 * @since 11-Jun-16.
 */
public class LevelSetsReader {
    /**
     * read level sets.
     *
     * @param reader reader containing path.
     * @return sets list
     */
    public static List<LevelSet> fromReader(java.io.Reader reader) {
        List<LevelSet> sets = new LinkedList<>();
        String str;
        List<String> lines = new LinkedList<>();
        LevelSpecificationReader lsr = new LevelSpecificationReader();

        //reading
        try (LineNumberReader lnr = new LineNumberReader(reader)) {
            while ((str = lnr.readLine()) != null) {
                lines.add(str);
            }
        } catch (IOException e) {
            System.out.println("Error reading level sets file");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file!");
            }
        }

        //creating sets
        for (int i = 0; i < lines.size(); i += 2) {
            String[] split = lines.get(i).split(":");
            List<LevelInformation> levelsList = null;

            levelsList = lsr.fromReader(new BufferedReader(
                    new InputStreamReader(ClassLoader.getSystemClassLoader()
                            .getResourceAsStream(lines.get(i + 1)))));

            sets.add(new LevelSet(split[0], split[1], levelsList));
        }

        return sets;
    }
}
