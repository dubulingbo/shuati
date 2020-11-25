package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-11-03 13:39
 * i believe i can i do
 */
public class T17_16 {
    // 面试题 17.16. 按摩师
    // 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
    // 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
    // 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
    //
    // 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
    public int massage(int[] nums) {
        // 动态规划
        // dp[i][1]表示第i个预约接的情况下，前i个预约的最长时间
        // 即 dp[i][1] = dp[i-1][0] + nums[i]，第i-1个预约就一定不能接
        // dp[i][0]表示第i个预约不接的情况下，前i个预约的最长时间
        // 即 dp[i][0] = max(dp[i-1][0],dp[i-1][1]，第i-1可接可不接，只取最大的预约时间
        if(nums.length == 0) return 0;
//        int[][] dp = new int[nums.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//            dp[i][1] = dp[i - 1][0] + nums[i];
//        }
//        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);

        // 因为dp[i]只与dp[i-1]有关，故：原地dp
        int dp0 = 0, dp1 = nums[0], t;

        for (int i = 1; i < nums.length; i++) {
            t = dp0;
            dp0 = Math.max(t,dp1);
            dp1 = t + nums[i];
        }

        return Math.max(dp0,dp1);
    }

    public static void main(String[] args) {
        System.out.println(new T17_16().massage(new int[]{}));
        System.out.println(new T17_16().massage(new int[]{1,2,3,1}));
        System.out.println(new T17_16().massage(new int[]{2,7,9,3,1}));
        System.out.println(new T17_16().massage(new int[]{2,1,4,5,3,1,1,3}));
    }
}
