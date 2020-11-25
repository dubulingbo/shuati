package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 14:13
 * i believe i can i do
 */
public class T58 {
    // 58. 最后一个单词的长度
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int k = s.length() - 1;
        while (k >= 0 && s.charAt(k) != ' ') k--;

        return s.length() - 1 - k;
    }
}
