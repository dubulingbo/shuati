package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 12:10
 * i believe i can i do
 */
public class T27 {
    // 27. 移除元素
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new T27().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
        String s = "hello";
        String tmp = "ll";
        System.out.println(s.indexOf(tmp));
    }
}
