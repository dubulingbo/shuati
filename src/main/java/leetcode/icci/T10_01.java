package leetcode.icci;


import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-10-29 20:20
 * i believe i can i do
 */
public class T10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        if (B.length == 0) return;
        int[] a = Arrays.copyOfRange(A, 0, m);
        int i = 0;
        int j = 0;
        for (int k = 0; k < A.length; k++) {
            if(i == m) A[k] = B[j++];
            else if(j == n) A[k] = a[i++];
            else A[k] = a[i] > B[j] ? B[j++] : a[i++];
        }
    }
}
