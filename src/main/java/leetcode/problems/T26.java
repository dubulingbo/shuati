package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 11:17
 * i believe i can i do
 */
public class T26 {
    // 26. 删除排序数组中的重复项
    // 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    public int removeDuplicates(int[] nums) {
        // 双指针 + 数组遍历 + 原地修改数组
        if (nums.length < 2) return nums.length;
        // 记录当前无重复元素的数组的新长度
        int k = 0;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[++k] = nums[i];
            }
        }

        return k + 1;
    }

}
