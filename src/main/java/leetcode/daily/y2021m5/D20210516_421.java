package leetcode.daily.y2021m5;

public class D20210516_421 {
    // 	421	数组中两个数的最大异或值
    // https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
    // 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
    // 进阶：你可以在 O(n) 的时间解决这个问题吗？
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}
