package leetcode.problems;

public class T154 {
    // 154. 寻找旋转排序数组中的最小值 II
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(left == right) return nums[left];
            if(mid + 1 <= right && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(mid - 1 >= left && nums[mid-1] > nums[mid])return nums[mid];

            if(nums[0] > nums[mid]){
                right = mid - 2;
            } else {
              left = mid + 2;
            }
        }
        return Integer.MIN_VALUE;


    }
}
