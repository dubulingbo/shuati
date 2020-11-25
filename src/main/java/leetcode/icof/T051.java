package leetcode.icof;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-10-15 16:11
 * i believe i can i do
 */
public class T051 {
    // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    // 输入一个数组，求出这个数组中的逆序对的总数。

    private int[] assist;
    public int reversePairs_divide(int[] nums) {
        // 分治法：归并排序

        if (nums.length < 2) return 0;

        // 存放有序的 nums 数组
        int[] sortArr = Arrays.copyOfRange(nums, 0, nums.length);

        assist = new int[nums.length];

        return countReversePairs(sortArr, 0, nums.length - 1);
    }

    /**
     * arr[left,right] 计算逆序对个数并排序
     *
     * @param arr   统计的数组（排序数组）
     * @param left  数组的左下标
     * @param right 数组的右下标
     */
    private int countReversePairs(int[] arr, int left, int right) {
        if (left == right) return 0;

//        if (left + 1 == right) { // 只有两个数，可以直接判断
//            return arr[left] > arr[right] ? 1 : 0;
//        }

        int mid = left + (right - left) / 2;

        int leftPairs = countReversePairs(arr, left, mid);
        int rightPairs = countReversePairs(arr, mid + 1, right);

        // arr[left,mid] 和 arr[mid+1,right] 已经有序，
        // 故它们之间就不存在逆序对
        if (arr[mid] <= arr[mid + 1]) {
            return leftPairs + rightPairs;
        }

        // 计算数组 arr[left,mid] 和 arr[mid+1,right] 之间的逆序数
        int crossPairs = mergeAndCount(arr, left, mid, right);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * arr[left,mid] 有序，arr[mid+1,right] 有序
     *
     * @param arr    统计的数组
     * @param left   左下标
     * @param mid    分支下标
     * @param right  右下标
     * @return arr[mid+1,right] 中个元素在整个数组 arr[right,left] 中的逆序对数
     */
    private int mergeAndCount(int[] arr, int left, int mid, int right) {
        // 直接借助 辅助数组tmp 进行交换
        System.arraycopy(arr, left, assist, left, right - left + 1);
//        for (int i = left; i <= right; i++) {
//            assist[i] = arr[i];
//        }

        int i = left;
        int j = mid + 1;
        int cnt = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) { // 右边有序数组已经遍历完
                arr[k] = assist[j++];
            } else if (j == right + 1) { // 左边有序数组已经遍历完
                arr[k] = assist[i++];
            } else if (assist[i] <= assist[j]) { // 不存在逆序
                arr[k] = assist[i++];
            } else {
                arr[k] = assist[j++];
                cnt += (mid - i + 1);
            }
        }
        return cnt;
    }

    public int reversePairs(int[] nums) {
        int ans = 0;

        // 暴力法：超时
        for (int i = 1; i < nums.length; i++) {
            int sum = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    sum++;
                }
            }
            ans += sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T051().reversePairs_divide(new int[]{7, 5, 6, 4}));
    }
}
