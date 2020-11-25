package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-11 21:14
 * i believe i can i do
 */
public class T806 {
    // 806. 写字符串需要的行数
    public int[] numberOfLines(int[] widths, String S) {
        // 模拟
        int rowSum = 1;
        int curRowSum = 0;
        for (int i = 0; i < S.length(); i++) {
            curRowSum += widths[S.charAt(i) - 'a'];
            // 写 第 i 个字符时会超过本行的最大长度
            if (curRowSum > 100) {
                rowSum++;
                curRowSum = widths[S.charAt(i) - 'a'];
            }
        }
        return new int[]{rowSum, curRowSum};
    }
}
