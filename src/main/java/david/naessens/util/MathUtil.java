package david.naessens.util;

import java.util.Collection;


/**
 * The type Math util.
 */
public class MathUtil {
    /**
     * The number of match to be played.
     *
     * @param n the n
     * @return the int
     */
    public static int nbMatch(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += i;
        }
        return res;
    }

    /**
     * Sum the numbers of an array.
     *
     * @param n the n
     * @return the int
     */
    public static int sumArray(Collection<Integer> n) {
        int sum = 0;
        for (int d : n)
            sum += d;
        return sum;
    }

    /**
     * Test if a number is a power of two.
     *
     * @param n the number to test
     * @return the boolean
     */
    public static boolean isAPowerOfTwo(int n) {
        int tmp = n;
        while (tmp > 1) {
            tmp /= 2;
        }
        return tmp == 0;
    }
}
