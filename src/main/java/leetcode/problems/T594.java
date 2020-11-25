package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author DubLBo
 * @since 2020-11-14 11:27
 * i believe i can i do
 */
public class T594 {
    // 594. 最长和谐子序列
    // 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是 1 。
    // 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
    public int findLHS01(int[] nums) {
        // HashMap
        if (nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLen = 0;
        for (int k : map.keySet()) {
            if (map.containsKey(k + 1)) {
                maxLen = Math.max(maxLen, map.get(k) + map.get(k + 1));
            }
        }

        return maxLen;
    }

    public int findLHS02(int[] nums) {
        // HashMap + 一次数组遍历
        if (nums.length == 0) return 0;
        // 存储元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int num : nums) {
            // 先建立 hash 索引
            map.put(num, map.getOrDefault(num, 0) + 1);
            // 如果有比当前数大 1 的数出现，计算此次的长度
            if (map.containsKey(num + 1)) {
                maxLen = Math.max(maxLen, map.get(num + 1) + map.get(num));
            }
            // 如果有比当前数小 1 的数出现，计算此次的长度
            if (map.containsKey(num - 1)) {
                maxLen = Math.max(maxLen, map.get(num - 1) + map.get(num));
            }
        }
        return maxLen;
    }

    public int findLHS(int[] nums){
        // 排序 + 双指针
        int maxLen = 0;
        int prev = 0, i = 0;
        // 先排序
        Arrays.sort(nums);
        while(i < nums.length){
            int minNum = nums[prev];
            // 从当前位置往后找最大值和最小值相差不超过 1 的最远距离
            while(i < nums.length && nums[i] - minNum < 2) i++;

            // 这里需要排除 nums[i...j-1]全是同一个数的情况
            maxLen = Math.max(maxLen, nums[i-1] == minNum ? 0 : i - prev);

            // 除去和 minNum 相等的所有数，为下个回合的循环做准备
            while(prev < i && nums[prev] == minNum) prev++;
        }
        return maxLen;
    }
}
