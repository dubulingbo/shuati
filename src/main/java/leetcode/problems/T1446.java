package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-16 16:00
 * i believe i can i do
 */
public class T1446 {
    // 连续的字符
    public int maxPower(String s) {
        char[] chs = s.toCharArray();
        int prev = -1;
        int ans = 0;
        for (int i = 0; i < chs.length; i++) {
            if (i == chs.length - 1) {
                // 处理最后一个字符
                ans = Math.max(ans, i - prev);
            } else if (prev == -1 || chs[i] != chs[i - 1]) {
                ans = Math.max(ans, i - prev);
                prev = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T1446().maxPower("leetcode"));
        System.out.println(new T1446().maxPower("letcode"));
    }
}
