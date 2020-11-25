package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-21 23:22
 * i believe i can i do
 */
public class T8 {
    // 8. 字符串转换整数 (atoi)
    public int myAtoi(String s) {
        int cur = 0;
        int symbol = 1;
        long num = 0;
        while (cur < s.length()) {
            // 去掉首部的空格，以及 是否第一个非空字符是符号位
            if (cur == 0) {
                while (cur < s.length() && s.charAt(cur) == ' ') cur++;
                if (cur < s.length() && s.charAt(cur) == '-' || s.charAt(cur) == '+') {
                    symbol = s.charAt(cur) == '-' ? -1 : 1;
                    cur++;
                    continue;
                }
            }

            // 处理最长连续的数字
            char c = s.charAt(cur);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                // 判断是否越界
                if (symbol * num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (symbol * num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                // 结束解析的过程
                break;
            }
            cur++;
        }

        return (int) (symbol * num);
    }

    public static void main(String[] args) {

        System.out.println(new T8().myAtoi("   -42"));
        System.out.println(new T8().myAtoi("2131  131"));
        System.out.println(new T8().myAtoi("4193 with words"));
        System.out.println(new T8().myAtoi("words and 987"));
        System.out.println(new T8().myAtoi("-91283472332"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE / 10);
        System.out.println(-19 % 10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE / 10);


    }
}
