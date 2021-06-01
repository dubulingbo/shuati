package leetcode.daily.y2021m2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author habitplus
 * @since 2021-02-01 15:57
 */
public class D1 {
    // 时隔一个多月没刷题了，手都生了，现在开始重新开始每日一题
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : A) sumA += i;
        for (int i : B) {
            sumB += i;
            set.add(i);
        }

        // 对 爱丽丝所拥有的糖果进行循环
        for (int k : A) {
            // 爱丽丝可能要把当前糖果给鲍勃
            int var = sumB + 2* k - sumA;
            // 如果鲍勃能拿这颗糖果，那应该是自己能给出正好多余爱丽丝糖果总量之外的一半的一颗糖果
            if (var > 0 && var % 2 == 0 && set.contains(var>>1)) {
                return new int[]{k, var>>1};
            }
        }

        return new int[2];
    }
}
