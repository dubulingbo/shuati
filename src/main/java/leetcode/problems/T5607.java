package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-22 14:03
 * i believe i can i do
 */
public class T5607 {
    // 5607. 生成平衡数组的方案数
    public int waysToMakeFair(int[] nums) {
        // 动态规划：
        // 从后往前分别记录偶数下标、奇数下标的元素和
        // 删除某个下标元素和，只会对其后元素的下标减一，即原来的偶数下标就会变成奇数下标，原来的奇数下标就会变成偶数下标
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return 0;

        int[] rightSum = new int[n + 2];
        int oddSum = 0, evenSum = 0;
        // 从后往前分别求 奇数、偶数下标元素和
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                evenSum += nums[i];
                rightSum[i] = evenSum;
            } else {
                oddSum += nums[i];
                rightSum[i] = oddSum;
            }
        }

        oddSum = 0;
        evenSum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // 删除的是偶数下标
                // 左边奇数下标元素和 + 右边偶数下标元素和 == 左边偶数下标元素和 + 右边奇数下标元素和
                if (oddSum + rightSum[i + 2] == evenSum + rightSum[i + 1]) {
                    ans++;
                }
                evenSum += nums[i];
            } else {
                // 删除的是奇数下标
                // 左边奇数下标元素和 + 右边偶数下标元素和 == 左边偶数下标元素和 + 右边奇数下标元素和
                if (oddSum + rightSum[i + 1] == evenSum + rightSum[i + 2]) {
                    ans++;
                }
                oddSum += nums[i];
            }
        }
        return ans;
    }
}
