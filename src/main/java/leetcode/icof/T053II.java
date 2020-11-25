package leetcode.icof;

/**
 * @author DubLBo
 * @since 2020-10-15 22:19
 * i believe i can i do
 */
public class T053II {

    public int missingNumber(int[] nums) {
        // 直接法
//        for(int i=0;i<nums.length;i++){
//            if(i != nums[i])
//                return i;
//        }
//        return nums.length;

        // 二分法
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if(mid == nums[mid]){
                // 说明 0~mid 这些数未缺失
                i = mid + 1;
            } else {
                // 说明缺失数在 nums[0,mid-1]里面
                j = mid - 1;
            }
        }
        return i;
    }

}
