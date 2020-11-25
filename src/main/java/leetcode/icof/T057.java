package leetcode.icof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author DubLBo
 * @since 2020-10-16 16:31
 * i believe i can i do
 */
public class T057 {
    // 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
    // 如果有多对数字的和等于s，则输出任意一对即可。
    public int[] twoSum(int[] nums, int target) {
        // hash set
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(nums[0]);

        int[] res = new int[0];
        for (int i = 1; i < nums.length; i++) {
            if (hashSet.contains(target - nums[i])) {
                res = new int[]{target - nums[i], nums[i]};
                break;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return res;

    }

    public int[] twoSum_double_ptr(int[] nums, int target) {
        // 双指针（首尾指针）法
        int[] res = new int[0];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (target < nums[i] + nums[j]) j--;
            else if (target > nums[i] + nums[j]) i++;
            else return new int[]{nums[i], nums[j]};
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T057().twoSum_double_ptr(new int[]{10, 40, 30, 30, 47, 40}, 40)));
    }
}
