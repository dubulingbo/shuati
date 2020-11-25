package leetcode.problems;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-11 21:46
 * i believe i can i do
 */
public class T976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] > A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
