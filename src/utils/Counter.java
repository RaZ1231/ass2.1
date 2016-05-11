package utils;

/**
 * a simple class that is used for counting things.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    /**
     * add number to current count.
     *
     * @param number add number to current count.
     */
    public void increase(int number) {
        count += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number subtract number from current count.
     */
    //
    public void decrease(int number) {
        count -= number;
    }

    /**
     * returns current count.
     *
     * @return current count.
     */
    public int getValue() {
        return count;
    }

    @Override
    public String toString() {
        return "(" + count + ")";
    }
}
