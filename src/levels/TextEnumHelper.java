package levels;

/**
 * Enum helper class.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public class TextEnumHelper<T> {
    /**
     * search enum by text.
     *
     * @param values enum constants
     * @param text   search text
     * @return found enum
     */
    public T valueOfText(TextEnum[] values, String text) {
        for (TextEnum value : values) {
            if (text.equals(value.getText()) || text.matches(value.getText())) {
                return (T) value;
            }
        }

        //not found
        throw new IllegalArgumentException(
                "{" + text + "} enum text not found in [" + values.getClass() + "].");
    }
}
