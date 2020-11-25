package leetcode.icof;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-10-20 13:09
 * i believe i can i do
 */
public class T057II {
    public int[][] findContinuousSequence(int target) {
        // 假设存在起始数为 start，连续的 n 个正整数的和为 target，则：
        // start + start+1 + start+2 + ... + start+(m-1) = target
        // 即：n*start + n(n-1)/2 = target
        // 所以只需对n枚举就能得出所有和为target的连续正整数序列
        // 根据题意，不难得知 2 <= n <= (target-1)/2 （向下取整）

        ArrayList<int[]> res = new ArrayList<>();
        int n = target / 2;
        for (int i = n - 1; i > 1; i--) {
            int start = target - i * (i - 1) / 2;

            if (start > 0 && start % i == 0) { // 存在一个正整数序列
                start /= i;
                int[] tmp = new int[i];
                for (int j = 0; j < i; j++) {
                    tmp[j] = start + j;
                }
                res.add(tmp);
            }
        }

        return res.toArray(new int[0][res.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T057II().findContinuousSequence(9)));
    }
}
