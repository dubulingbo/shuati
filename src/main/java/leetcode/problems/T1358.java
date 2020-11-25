package leetcode.problems;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-04 13:26
 * i believe i can i do
 */
public class T1358 {
    // 1358. 包含所有三种字符的子字符串数目
    // 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
    // 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
    public int numberOfSubstrings(String s) {
        // 记录 a，b，c最近一次出现的位置
//        int[] recentIndex = new int[3];
//        int ans = 0;
//        char[] chs = s.toCharArray();
//        for (int i = 0; i < chs.length; i++) {
//            recentIndex[chs[i] - 'a'] = i + 1;
//            if (recentIndex[0] > 0 && recentIndex[1] > 0 && recentIndex[2] > 0) {
//                ans += Math.min(Math.min(recentIndex[0], recentIndex[1]), recentIndex[2]);
//            }
//        }
//        return ans;


        // 优化：其实可以不用判断是否已经有出现过a,b,c，只需要将初始值设为-1，因为 -1 + 1 = 0
        int[] recentIndex = new int[3];
        // 初始值只能设为 -1
        Arrays.fill(recentIndex, -1);
        int ans = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            recentIndex[chs[i] - 'a'] = i;
            ans += (Math.min(Math.min(recentIndex[0], recentIndex[1]), recentIndex[2]) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T1358().numberOfSubstrings("abcabc"));
        System.out.println(new T1358().numberOfSubstrings("ccccab"));
    }
}
