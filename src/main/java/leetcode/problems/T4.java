package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-20 17:13
 * i believe i can i do
 */
public class T4 {
    // 4. 寻找两个正序数组的中位数
    public double findMedianSortedArrays01(int[] nums1, int[] nums2) {
        // 类似合并两个有序数组 + 计数，O( (m+n)/2 )
        if (nums1.length == 0 && nums2.length == 0) return 0.0;
        int m = nums1.length;
        int n = nums2.length;
//        if (m == 0) return n % 2 == 0 ? (nums2[n / 2] + nums2[n / 2 - 1]) * 0.5 : nums2[n / 2] * 0.5;
//        if (n == 0) return m % 2 == 0 ? (nums1[m / 2] + nums1[m / 2 - 1]) * 0.5 : nums1[m / 2] * 0.5;

        // int mid = (m + n) / 2;
        int i = 0, j = 0;
        // 存储 cur 的 前一位（m+n 为偶数的情况）
        int prev = 0;
        int cur = 0;
        // 依次从第1位 枚举到 第 m+n/2 位
        for (int k = (m + n) / 2; k >= 0; k--) {
            prev = cur;
            if (i == m) {
                cur = nums2[j];
                j++;
            } else if (j == n) {
                cur = nums1[i];
                i++;
            } else {
                if (nums1[i] > nums2[j]) {
                    cur = nums2[j];
                    j++;
                } else {
                    cur = nums1[i];
                    i++;
                }
            }
        }

        return (m + n) % 2 == 0 ? (prev + cur) * 0.5 : cur;
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        // 二分法，O(log(m+n))
//
//    }

}
