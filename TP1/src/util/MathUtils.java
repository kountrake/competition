package util;

import java.util.List;

public  class MathUtils {
    public static int fact (int n) {
        if (n==0) return(1);
        else return(n*fact(n-1));
    }

    public static int sumArray (List<Integer> n){
        int sum = 0;
        for(int d : n)
            sum += d;
        return sum;
    }
}
