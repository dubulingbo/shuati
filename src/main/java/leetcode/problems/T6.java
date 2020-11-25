package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-21 13:04
 * i believe i can i do
 */
public class T6 {
    // 6. Z 字形变换
    public String convert(String s, int numRows) {
        // 按行输出，
        if (numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    sb.append(s.charAt(j + cycleLen - i));
            }
        }
        return sb.toString();
    }
}
