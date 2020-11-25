package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-09 16:51
 * i believe i can i do
 */
public class T198 {
    //
    public int rob(int[] nums) {
        // 动态规划
        // dp[i][0] 表示不偷窃第i间房屋的最大利益，那么，第i-1间偷不偷都可以，只取最大值就行，即：
        // dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        // dp[i][1] 表示偷窃第i间房屋的最大利益，那么，为了不触发报警系统，第i-1间房屋一定不能偷，即：
        // dp[i][1] = max(dp[i-1][0] + nums[i],dp[i-1][0])
        if(nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
            // 题目给出的数组元素都是非负的，所以直接加上肯定不会比之前的小
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[nums.length - 1][0],dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
        System.out.println(new T198().rob(new int[]{1,2,3,1}));
        System.out.println(new T198().rob(new int[]{2,7,9,3,1}));
        System.out.println(new T198().rob(new int[]{}));
    }
}
