package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-12 19:43
 * i believe i can i do
 */
public class T153 {
    // 153. 寻找旋转排序数组中的最小值
    // 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]。
    // 请找出其中最小的元素。
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        if(nums[left] <= nums[right]) return nums[left];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (left == right) return nums[left];

            if (mid + 1 <= right && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if (mid - 1 >= left && nums[mid - 1] > nums[mid]) return nums[mid];

            if (nums[0] > nums[mid]) {
                right = mid - 2;
            } else {
                left = mid + 2;
            }
        }
        return -1;
    }
}
