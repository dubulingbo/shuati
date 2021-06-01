package leetcode.daily.y2020m11;

/**
 * @author DubLBo
 * @since 2020-11-03 12:29
 * i believe i can i do
 */
public class D20201103_941 {
    // 有效的山脉数组
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;

        int left = 0;
        int right = A.length - 1;

        // 单调递增段
        while (left < right && A[left] < A[left + 1]) left++;
        // 单调递减段
        while (right > 0 && A[right] < A[right - 1]) right--;

        if(left == A.length - 1 || right == 0) return false;
        return left == right;
    }

    public static void main(String[] args) {
        System.out.println(new D20201103_941().validMountainArray(new int[]{2,1}));
        System.out.println(new D20201103_941().validMountainArray(new int[]{3,5,5}));
        System.out.println(new D20201103_941().validMountainArray(new int[]{-1,0,3,3,2,1}));
    }

}
