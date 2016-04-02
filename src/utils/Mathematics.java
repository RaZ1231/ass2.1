package utils;

/**
 * @author Raziel Solomon
 * @since 19-Mar-16.
 */

/**
 * Mathematics functions.
 */
public class Mathematics {
    /**
     * Calculates average of two numbers.
     *
     * @param num1 first number
     * @param num2 second number
     * @return average
     */
    public static double average(double num1, double num2) {
        return (num1 + num2) / 2;
    }

    /**
     * Determines if var is between the numbers.
     *
     * @param num1 first border
     * @param var  number
     * @param num2 second border
     * @return true\false
     */
    public static boolean isBetween(double num1, double var, double num2) {
        return (num1 <= var && var <= num2) || (num2 <= var && var <= num1);
    }

    /**
     * Return a^2 + b^2.
     *
     * @param a first number
     * @param b second number
     * @return c^2
     */
    public static double pythagoras(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /**
     * Convet string array to int array.
     *
     * @param sArr string array to convert
     * @return Int array
     */
    public static int[] stringsToInts(String[] sArr) {
        int[] iArr = new int[sArr.length];

        for (int i = 0; i < sArr.length; i++) {
            iArr[i] = Integer.parseInt(sArr[i]);
        }

        return iArr;
    }
}
