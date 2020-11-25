package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {
    // 15. 三数之和
    // 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    // 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序 + 枚举 + 优化
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        // 枚举第一个数
        for (int i = 0; i < n; i++) {
            // 枚举的数和上次的相同就不要进行枚举了
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int k = n - 1;
            // 枚举第二个数
            for (int j = i + 1; j < nums.length; j++) {
                // 枚举的上一个数和当前数相等，直接枚举下一个数
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 从后往前搜索到第一个满足 nums[i] + nums[j] + nums[right] <= 0 的位置
                while (j < k && nums[i] + nums[j] + nums[k] > 0) k--;

                // 指向同一个数，那就说明本次是找不到满足条件的三个数
                if (j == k) break;

                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(nums[k]);
                    resList.add(tmpList);
                }
            }
        }

        return resList;
    }
}
