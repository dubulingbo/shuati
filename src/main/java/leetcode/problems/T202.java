package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author DubLBo
 * @since 2020-11-09 16:03
 * i believe i can i do
 */
public class T202 {
    public boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<>();
        while (n != 1 && !hash.contains(n)) {
            hash.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int res = 0;
        int t;
        while (n > 0) {
            t = n % 10;
            res += (t * t);
            n /= 10;
        }
        return res;
    }
}
