package leetcode.problems;

import java.util.HashSet;

/**
 * @author DubLBo
 * @since 2020-11-20 15:55
 * i believe i can i do
 */
public class T3 {
    // 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring01(String s) {
        // hash表 （滑动窗口）
        char[] chs = s.toCharArray();
        // 引入【hash表】的目的是可以在 O(1)的时间内快速查重
        HashSet<Character> hash = new HashSet<>();
        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < chs.length; i++) {
            // 当前字符 chs[i] 开始的最长不重复子串
            while (j < chs.length && !hash.contains(chs[j])) {
                hash.add(chs[j]);
                j++;
            }

            // chs[i,j) 就为从 chs[i] 字符开始的最长不重复子串
            maxLen = Math.max(maxLen, j - i);

            // 滑动窗口前移一位，枚举下一个位置，
            // 这个时候应该注意 chs[i+1, j) 这些字符就是不重复的子串，
            // 因此，下个位置的判断只需从 chs[j] 开始
            hash.remove(chs[i]);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring02(String s) {
        // StringBuilder （滑动窗口）
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < chs.length; i++) {
            // 当前字符 chs[i] 开始的最长不重复子串
            while (j < chs.length && !sb.toString().contains(String.valueOf(chs[j]))) {
                sb.append(chs[j]);
                j++;
            }

            // chs[i,j) 就为从 chs[i] 字符开始的最长不重复子串
            maxLen = Math.max(maxLen, j - i);

            // 滑动窗口前移一位，枚举下一个位置，
            // 这个时候应该注意 chs[i+1, j) 这些字符就是不重复的子串，因此，下个位置的判断只需从 chs[j] 开始
            sb.deleteCharAt(0);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        // 记录最近字符出现的位置下标
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i);
            start = Math.max(start, last[c] + 1);
            res = Math.max(res, i - start + 1);
            last[c] = i;
        }

        return res;
    }
}
