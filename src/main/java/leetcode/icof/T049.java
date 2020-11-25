package leetcode.icof;

import java.util.PriorityQueue;

/**
 * @author DubLBo
 * @since 2020-10-15 08:52
 * i believe i can i do
 */
public class T049 {
    // 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
    // 任何丑数乘以2,3,5还是丑数
    public int nthUglyNumber_minHeap(int n) {
        // 法一：小根堆
        // 可能会超过 int 类型的范围
        long res = 1;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int[] uglyNum = {2, 3, 5};
        minHeap.add(res);
        int count = 0;
        while (!minHeap.isEmpty()) {
            res = minHeap.poll();

            if (++count == n) {
                // 当前 res 就是答案
                break;
            }

            for (int ugly : uglyNum) {
                if (!minHeap.contains(res * ugly)) {
                    minHeap.add(res * ugly);
                }
            }
        }

        return (int) res;
    }

    public int nthUglyNumber_dp(int n) {
        // 法二：动态规划
        // dp[i] 表示从小到大的第 i+1 个丑数
        int[] dp = new int[n];
        // x2 为乘以 2 的下标
        // x3 为乘以 3 的下标
        // x5 为乘以 5 的下标
        int i2 = 0, i3 = 0, i5 = 0;

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int v1 = dp[i2]*2;
            int v2 = dp[i3]*3;
            int v3 = dp[i5]*5;

            dp[i] = Math.min(Math.min(v1,v2),v3);

            if(dp[i] == v1) i2++;
            if(dp[i] == v2) i3++;
            if(dp[i] == v3) i5++;
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new T049().nthUglyNumber_minHeap(1690));
        System.out.println(new T049().nthUglyNumber_dp(1690));
    }
}
