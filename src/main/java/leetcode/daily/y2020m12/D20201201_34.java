package leetcode.daily.y2020m12;

public class D20201201_34 {
    // 34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        // 二分法
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //向左搜索
                int lMid = mid;
                while (lMid >= left && nums[lMid] == target) lMid--;

                // 向右搜索
                int rMid = mid;
                while (rMid <= right && nums[rMid] == target) rMid++;

                return new int[]{lMid + 1, rMid - 1};
            }
        }

        return new int[]{-1, -1};
    }

}
