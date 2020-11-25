package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-15 14:39
 * i believe i can i do
 */
public class T1431 {
    //
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
//        if (candies.length == 0) return new ArrayList<>();
//        Boolean[] res = new Boolean[candies.length];
//        int[][] arr = new int[candies.length][2];
        int max = 0;
        for (int j : candies) max = Math.max(max, j);

        for (int candy : candies) res.add(candy + extraCandies >= max);

        return res;
    }
}
