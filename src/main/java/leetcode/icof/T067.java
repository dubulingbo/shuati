package leetcode.icof;

/**
 * @author DubLBo
 * @since 2020-10-21 10:58
 * i believe i can i do
 */
public class T067 {
    public int strToInt(String str) {
        // 处理前后的空格
        char[] chs = str.trim().toCharArray();

        if (chs.length == 0) return 0;

        // 表示进位
        int maxInt = Integer.MAX_VALUE / 10;
        int ans = 0;
        // 表示符号，默认为正号
        int sign = 1;
        // 标记转化开始的下标
        int st = 1;
        if (chs[0] == '-') sign = -1;
        else if(chs[0] != '+') st = 0;

        for (int i = st; i < chs.length; i++) {
            if (chs[i] > '9' || chs[i] < '0') {
                break;
            } else if (ans > maxInt || (ans == maxInt && chs[i] - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = 10 * ans + (chs[i] - '0');
        }
        return ans * sign;
    }
}
