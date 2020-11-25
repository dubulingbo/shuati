package leetcode.problems;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-10 14:22
 * i believe i can i do
 */
public class T66 {
    // 66. 加一
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return new int[0];

        int[] res = new int[digits.length + 1];
        // 代表进位
        int k = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            k += digits[i];
            res[i + 1] = k % 10;
            k /= 10;
        }

        if (k != 0) {
            res[0] = k;
            return res;
        } else {
            return Arrays.copyOfRange(res, 1, res.length);
        }
    }
}
