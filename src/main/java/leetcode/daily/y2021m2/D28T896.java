package leetcode.daily.y2021m2;

/**
 * @author habitplus
 * @since 2021-02-28 12:50
 */
public class D28T896 {
    public boolean isMonotonic(int[] A) {
        if (A.length < 3) {
            return true;
        }

        int order = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] == A[i]) continue;
            int t = A[i-1] > A[i] ? 1 : 2;
            if (order != 0 && order != t) {
                return false;
            }
            order = t;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new D28T896().isMonotonic(new int[]{1,2,2,3}));
        System.out.println(new D28T896().isMonotonic(new int[]{6,5,4,4}));
        System.out.println(new D28T896().isMonotonic(new int[]{1,3,2}));
        System.out.println(new D28T896().isMonotonic(new int[]{1,2,4,5}));
        System.out.println(new D28T896().isMonotonic(new int[]{1,1,1}));
    }
}
