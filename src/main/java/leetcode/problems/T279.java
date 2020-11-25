package leetcode.problems;

import java.util.Arrays;

public class T279 {
    // 279. 完全平方数
    // 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
    // 你需要让组成和的完全平方数的个数最少。
    public int numSquares(int n) {
        // 动态规划
        // dp[i] 表示 平方和为 i 的最少平方数的数量
        int[] dp = new int[n + 1];


        // 最多只需要枚举到 sqrt(n) 的平方
        int max_n = (int) Math.sqrt(n);
//        int[] squareNum = new int[max_n];
//        for (int i = 1; i < max_n; i++) squareNum[i] = i * i;

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= max_n; j++) {
                // 如果当前数的平方就已经大于 i，直接跳出循环
                if (i < j * j) break;
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new T279().numSquares(1));
    }
}
