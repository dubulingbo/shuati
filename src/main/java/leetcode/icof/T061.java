package leetcode.icof;

import java.util.HashSet;
import java.util.Set;

/**
 * @author DubLBo
 * @since 2020-10-18 12:11
 * i believe i can i do
 */
public class T061 {
    // 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    // 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

    // 是顺子的充分条件是：
    // 1. 数字无重复（大小王除外）
    // 2. 最大的数和最小的数相差 小于5
    public boolean isStraight(int[] nums) {
        // hash set
        // 是顺子的充分条件是：
        // 1. 数字无重复（大小王除外）
        // 2. 最大的数和最小的数相差 小于5

        Set<Integer> hashSet = new HashSet<>();
        int minNum = 15, maxNum = 0;

        for (int num : nums) {
            // 排除大小王
            if (num == 0) continue;

            if (hashSet.contains(num)) {
                return false;
            } else {
                minNum = Math.min(minNum, num);
                maxNum = Math.max(maxNum, num);
                hashSet.add(num);
            }
        }

        return maxNum - minNum < 5;
    }

    public static void main(String[] args) {
        System.out.println(new T061().isStraight(new int[]{0,0,1,2,5}));
        System.out.println(new T061().isStraight(new int[]{0,0,1,2,4}));
        System.out.println(new T061().isStraight(new int[]{0,0,1,2,3}));
        System.out.println(new T061().isStraight(new int[]{0,0,3,2,3}));
        System.out.println(new T061().isStraight(new int[]{0,0,3,4,5}));
        System.out.println(new T061().isStraight(new int[]{0,0,2,4,6}));
        System.out.println(new T061().isStraight(new int[]{1,2,3,4,5}));
        System.out.println(new T061().isStraight(new int[]{1,2,3,4,6}));
    }

}
