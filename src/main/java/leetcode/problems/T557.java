package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class T557 {
    // 557. 反转字符串中的单词 III
    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder tmp = new StringBuilder();
        char[] chs = s.toCharArray();

        int pre = 0;
        for (int i = 0; i <= chs.length; i++) {
            if (i == chs.length || chs[i] == ' ') {
                int be = i - 1;
                while (pre < be) {
                    char c = chs[pre];
                    chs[pre++] = chs[be];
                    chs[be--] = c;
                }
                pre = i + 1;
            }
        }

        return new String(chs);
    }
}
