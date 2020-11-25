package leetcode.problems.divide_and_conquer;

/**
 * @author DubLBo
 * @since 2020-11-04 15:04
 * i believe i can i do
 */
public class T215 {
    // 分治算法
    //在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        while (left <= right) {
            int pos = partition(nums, left, right);

            if (pos == k - 1) {
                ans = nums[pos];
                break;
            } else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        return ans;
    }

    private int partition(int[] arr, int left, int right) {
        int key = arr[left];

        // arr[left..k-1] > arr[k]   and    arr[k+1...right] < arr[k]
        // 降序
        while (left < right) {
            // 从右往左 找第一个大于key的数的位置
            while (left < right && arr[right] <= key) right--;
            arr[left] = arr[right];
            // 从左往右找第一个小于key的数的位置
            while (left < right && arr[left] >= key) left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new T215().findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(new T215().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
