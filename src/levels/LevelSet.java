package levels;

import interfaces.LevelInformation;

import java.util.List;

/**
 * Level set class.
 *
 * @author Raziel Solomon
 * @since 11-Jun-16.
 */
public class LevelSet {
    private String key;
    private String name;
    private List<LevelInformation> levels;

    /**
     * constructor.
     *
     * @param key
     * @param name
     * @param levels
     */
    public LevelSet(String key, String name, List<LevelInformation> levels) {
        this.key = key;
        this.name = name;
        this.levels = levels;
    }

    /**
     * key getter.
     *
     * @return hot key
     */
    public String getKey() {
        return key;
    }

    /**
     * name getter.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * levels getter.
     *
     * @return levels in set
     */
    public List<LevelInformation> getLevels() {
        return levels;
    }
}
