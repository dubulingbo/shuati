package leetcode.problems;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-10 18:17
 * i believe i can i do
 */
public class T88 {
    // 88. 合并两个有序数组
    // 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
    // 说明：
    //      初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
    //      你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    public void merge01(int[] nums1, int m, int[] nums2, int n) {
        // 从前往后
        if (n == 0) return;
        int[] arr = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i == m) {
                nums1[k] = nums2[j++];
            } else if (j == n) {
                nums1[k] = arr[i++];
            } else if (nums2[j] < arr[i]) {
                nums1[k] = nums2[j++];
            } else {
                nums1[k] = arr[i++];
            }
            k++;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (j == -1) {
                // 可以直接结束循环
                break;
            } else if (i == -1) {
                nums1[k] = nums2[j--];
            } else if (nums2[j] > nums1[i]) {
                nums1[k] = nums2[j--];
            } else {
                nums1[k] = nums1[i--];
            }
            k--;
        }
    }

    public static void main(String[] args) {
        new T88().merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
