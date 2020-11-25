package leetcode.daily;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-19 12:41
 * i believe i can i do
 */
public class D20201119_283 {
    // 283. 移动零
    public void moveZeroes01(int[] nums) {
        // 分段 + 双指针
        // 指向非零的排序项的尾部
        int index = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        // 填充 0
        while(index < nums.length) nums[index++] = 0;
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0; right<nums.length;right++){
            if(nums[right] != 0 && left != right){
                // 交换
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        new D20201119_283().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
