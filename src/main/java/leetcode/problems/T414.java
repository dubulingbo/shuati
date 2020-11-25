package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author DubLBo
 * @since 2020-11-14 14:36
 * i believe i can i do
 */
public class T414 {
    // 414. 第三大的数
    // 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
    public int thirdMax01(int[] nums) {
        // 数组去重
        Set<Integer> set = new HashSet<>();
        int firstBigNum = Integer.MIN_VALUE;
        for (int x : nums) {
            if (firstBigNum < x) firstBigNum = x;
            set.add(x);
        }

        if (set.size() < 3) return firstBigNum;

        int secondBigNum = Integer.MIN_VALUE;
        int thirdBigNum = Integer.MIN_VALUE;

        for (int x : set) {
            if (x == firstBigNum) continue;
            if (x > secondBigNum) {
                thirdBigNum = secondBigNum;
                secondBigNum = x;
            } else if (x > thirdBigNum) {
                thirdBigNum = x;
            }
        }
        return thirdBigNum;
    }

    public int thirdMax(int[] nums) {
        // 三个变量，分别指向第一大的数、第二大的数和第三大的数

        // 这里赋值为 Long.MIN_VALUE 的最小值 是为了排除第三大的数就是 Integer.MIN_VALUE 的情况
        long firstBigNum = Long.MIN_VALUE;
        long secondBigNum = Long.MIN_VALUE;
        long thirdBigNum = Long.MIN_VALUE;

        for (int x : nums) {
            if (x > firstBigNum) {
                thirdBigNum = secondBigNum;
                secondBigNum = firstBigNum;
                firstBigNum = x;
            } else if (x < firstBigNum && x > secondBigNum) { // 排除了 x == firstBigNum 的情况
                thirdBigNum = secondBigNum;
                secondBigNum = x;
            } else if (x < secondBigNum && x > thirdBigNum) { // 排除了 x == secondBigNum 的情况
                thirdBigNum = x;
            }
        }
        return thirdBigNum == Long.MIN_VALUE ? (int) firstBigNum : (int) thirdBigNum;
    }
}

