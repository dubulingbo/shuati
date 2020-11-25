package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-14 22:52
 * i believe i can i do
 */
public class T5550 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) return res;

        int sum;

        if (k > 0) {
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += code[(i + 1 + j) % n];
                }
                res[i] = sum;
            }
        } else {
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = k; j < 0; j++) {
                    sum += code[(n + j + i) % n];
                }
                res[i] = sum;
            }
        }
        return res;
    }
}
