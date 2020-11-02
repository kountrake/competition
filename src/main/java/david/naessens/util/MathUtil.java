package david.naessens.util;

import java.util.Collection;


public class MathUtil {
    public static int nbMatch(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += i;
        }
        return res;
    }

    public static int sumArray(Collection<Integer> n) {
        int sum = 0;
        for (int d : n)
            sum += d;
        return sum;
    }

    public static boolean isAPowerOfTwo(int n) {
        int tmp = n;
        while (tmp > 1) {
            tmp /= 2;
        }
        return tmp == 0;
    }
}
