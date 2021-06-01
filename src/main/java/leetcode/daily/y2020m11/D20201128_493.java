package leetcode.daily.y2020m11;

import java.util.Arrays;

public class D20201128_493 {
    // 493. 翻转对
    public int reversePairs(int[] nums) {
        // 归并排序 + 统计
        return countReversePairs(nums, 0, nums.length - 1);
    }

    private int countReversePairs(int[] nums, int left, int right) {
        // 只有一个元素或没有元素，直接返回 0
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int leftCount = countReversePairs(nums, left, mid);
        int rightCount = countReversePairs(nums, mid + 1, right);

        // 合并两个有序的数组，并统计翻转对的数量
        int beCount = countAndMerge(nums, left, mid, right);

        return leftCount + beCount + rightCount;

    }

    /**
     * 统计两个有序的数组之间的翻转对的数量，nums[left,mid] 与 nums[mid+1,right]有序
     *
     * @param nums  待排序数组
     * @param left  左起点下标
     * @param mid   中间下标
     * @param right 右终点下标
     * @return 翻转对的数量，并且 nums[left,right] 有序
     */
    private int countAndMerge(int[] nums, int left, int mid, int right) {
        // 先统计翻转对的数量
        int i = left, j = mid + 1;
        int count = 0;
        int[] arr = Arrays.copyOfRange(nums, left, right + 1);
        while (i <= mid && j <= right) {
            // 这里 2 * arr[j] 可能会溢出，故转化成 long 型
            if (nums[i] > (long)2 * nums[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        // 合并
        i = 0;
        j = mid + 1 - left;
        int ri = mid - left + 1;
        int rj = right - left + 1;
        int k = left;
        while (i < ri || j < rj) {
            if (i == ri) {
                nums[k++] = arr[j++];
            } else if (j == rj) {
                nums[k++] = arr[i++];
            } else {
                if (arr[i] > arr[j]) nums[k++] = arr[j++];
                else nums[k++] = arr[i++];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new D20201128_493().reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
