package leetcode.problems;

import java.util.HashMap;

/**
 * @author DubLBo
 * @since 2020-11-13 20:23
 * i believe i can i do
 */
public class T167 {
    // 167. 两数之和 II - 输入有序数组
    public int[] twoSum01(int[] numbers, int target) {
        // hash map : O(n) + O(n)
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (hash.containsKey(target - numbers[i])) {
                return new int[]{i + 1, hash.get(target - numbers[i]) + 1};
            } else {
                hash.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum02(int[] numbers, int target) {
        // 二分法 ： O(n*logn) + O(n)
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] > target - numbers[i]) {
                    right = mid - 1;
                } else if (numbers[mid] < target - numbers[i]) {
                    left = mid + 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum03(int[] numbers, int target) {
        // 首尾双指针 ： O(n) + O(1)
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            // 目标比首尾和大，左指针右移
            if (target < numbers[left] + numbers[right]) {
                left++;
            } else if (target > numbers[left] + numbers[right]) {
                // 目标比首尾和小，右指针左移
                right--;
            } else {
                // 相等，即找到了这两个数
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

}
