package leetcode.icof;

/**
 * @author DubLBo
 * @since 2020-10-15 21:26
 * i believe i can i do
 */
public class T053I {
    // 暴力法不可取，推荐使用二分查找法
    // public int search(int[] nums, int target) {
    //     int ans = 0;
    //     // for(int num : nums){
    //     //     ans += num == target?1:0;
    //     // }
    //     while
    //     return ans;
    // }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target) - binarySearch(nums, target - 1);
    }

    // 在有序整型数组中找到第一个 <=target的数的下标
    // 二分查找法
    int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] <= target) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(new T053I().search(nums, 8));
        System.out.println(new T053I().search(new int[]{5,7,7,8,8,10}, 6));
    }
}
