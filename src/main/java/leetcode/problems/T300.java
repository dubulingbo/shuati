package leetcode.problems;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-15 13:41
 * i believe i can i do
 */
public class T300 {
    // 300. 最长上升子序列
    public int lengthOfLIS(int[] nums) {
        // 动态规划
        if (nums.length < 2) return nums.length;
        // dp[i] 表示以 nums[i] 结尾的最长子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new T300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new T300().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        System.out.println(new T300().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
