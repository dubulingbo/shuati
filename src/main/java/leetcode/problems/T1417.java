package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-15 15:02
 * i believe i can i do
 */
public class T1417 {
    // 1417. 重新格式化字符串
    public String reformat(String s) {
        int alpha = 0, number = 0;
        char[] chs = s.toCharArray();
        for (char c : chs) {
            if ('a' <= c && c <= 'z') alpha++;
            else number++;
        }

        if (Math.abs(alpha - number) > 2) return "";

        // 设置第一个位置存放数字还是字母
        // 数字比字母多，第一位放数字，否则，第一位放字母
        if (number > alpha) {
            number = 0;
            alpha = 1;
        } else {
            alpha = 0;
            number = 1;
        }
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                chs[alpha] = c;
                alpha += 2;
            } else {
                chs[number] = c;
                number += 2;
            }
        }
        return String.valueOf(chs);
    }

}
