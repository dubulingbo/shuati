package leetcode.problems;

import java.util.HashSet;

public class T219 {
    // 219. 存在重复元素 II
    // 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
    // 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashSet：滑动窗口
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) return true;
            else hash.add(nums[i]);

            if (hash.size() > k) hash.remove(nums[i - k]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T219().containsNearbyDuplicate(new int[0], 3));
        System.out.println(new T219().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(new T219().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
