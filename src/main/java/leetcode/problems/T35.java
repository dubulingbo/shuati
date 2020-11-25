package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 13:08
 * i believe i can i do
 */
public class T35 {
    // 35. 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        // 二分查找法
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }


        if (nums[mid] > target) {
            if(mid == 0) return 0;
            else if(nums[mid -1] < target) return mid;
            else return mid - 1;
        } else if (nums[mid] < target) return mid + 1;
        else return mid;
    }

    public static void main(String[] args) {
        System.out.println(new T35().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new T35().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new T35().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new T35().searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
