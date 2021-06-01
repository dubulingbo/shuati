package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author habitplus
 * @since 2020-12-19 21:49
 */
public class T131 {
    // 131. 分割回文串

    private char[] chs;

    public List<List<String>> partition(String s) {
        // 回溯 + 动态规划（递推）进行剪枝
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;

        /*
        // 动态规划做剪枝
        char[] chs = s.toCharArray();
        int n = chs.length;
        // flag[i][j] 标记 s[i:j]是否是回文串
        boolean[][] flag = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                // 当前首尾字符相等，并且 s[i+1:j-1]也是回文串
                // 当 j-i<=2 时，有了 s[i] = s[j]，则 s[i:j] 自然是回文串
                if ((chs[i] == chs[j]) && (j - i <= 2 || flag[i+1][j-1])) {
                    flag[i][j] = true;
                }
            }
        }
        */

        // 此处转化为字符数组，是为了提高访问速度
        chs = s.toCharArray();

        backtrack(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void backtrack(String s, int stIdx, LinkedList<String> tmpList, List<List<String>> res) {
        if (stIdx == s.length()) {
            res.add(new ArrayList<>(tmpList));
            return;
        }

        // 开始枚举所有可能的位置
        for (int i = stIdx; i < s.length(); i++) {
            if (isPalindrome(stIdx, i)) {
                // s[stIdx:i] 是回文串，可以从 i 处截断
                tmpList.add(s.substring(stIdx, i + 1));
                backtrack(s, i + 1, tmpList, res);
                tmpList.removeLast();
            }
        }
    }

    // 判断 s[left:right] 是否为回文串
    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (chs[left] != chs[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T131().partition("aab"));
        System.out.println(new T131().partition("sssss"));
    }
}
