package leetcode.icof;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-10-18 15:36
 * i believe i can i do
 */
public class T060 {
    // 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
    // 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

    public double[] twoSum(int n) {
        // 动态规划：dp

        // dp[i][j]表示投掷完 i 枚骰子后，点数 j 的出现次数。
        int[][] dp = new int[n + 1][6 * n + 1];
        //边界条件：初始条件
        for (int s = 1; s <= 6; s++) dp[1][s] = 1;

        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                //求dp[i][s]
                for (int d = 1; d <= 6; d++) {
                    if (s - d < i - 1) break;
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double total = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T060().twoSum(2)));
        System.out.println(Arrays.toString(new T060().twoSum(1)));
        System.out.println(Arrays.toString(new T060().twoSum(11)));
    }

}
