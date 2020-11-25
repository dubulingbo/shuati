package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-11 12:05
 * i believe i can i do
 */
public class D20201111_514 {
    // 514. 自由之路
    public int findRotateSteps(String ring, String key) {
        // 动态规划
        // 思路，始终以初始的下标表示ring上每个字符的绝对位置i，那么：
        // 假设当前12:00方向上的是位置j上的字符，那其他位置上的字符距离j的最短距离就是：
        //          Math.min(ring.length() - Math.abs(i - j), Math.abs(i - j))
        //
        // 时间复杂度：O(n*m^2)
        // 空间复杂度：O(n*m)
        int m = ring.length();
        int n = key.length();
        // if (m == 0 || n == 0) return -1;
        // dp[i][j] 表示 ring上12:00方向上第j个字符是 key的第i个字符（说明前i-1个字符已经匹配好了）的最少步数
        int[][] dp = new int[n][m];
        // 使用hash表存储 ring 的每个相同字符的绝对位置，方便进行快速定位
        // 由于题目给出的 ring 字符串只包含小写字母，故可以用数组模拟 hash table
        ArrayList<Integer>[] alphaPos = new ArrayList[26];

        // 初始化一些数据，这里将 dp 所有空间的值初始化为无穷大，是为了后续方便比较
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        // 将字母与位置建立索引，并且初始 key 上的第 0 个字符 的最少步数
        for (int i = 0; i < 26; i++) alphaPos[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            alphaPos[c - 'a'].add(i);
            if (c == key.charAt(0)) {
                // 起始位置为 0
                dp[0][i] = Math.min(m - i, i) + 1;
            }
        }

        int t;
        // 从 key 的第 1 个字符一直到第 n-1 个字符
        for (int i = 1; i < n; i++) {
            // 获取 ring 上所有与 key[i] 相等的字符的位置，进行枚举；
            for (int pos : alphaPos[key.charAt(i) - 'a']) {
                // 枚举上一个位置，即与 key[i-1] 相等的字符的位置
                for (int j : alphaPos[key.charAt(i-1) - 'a']) {
//                    if (dp[i - 1][j] != Integer.MAX_VALUE) {
                        // 说明上一个 12:00 的位置就是j
                    t = Math.min(m - Math.abs(pos - j), Math.abs(pos - j)) + 1 + dp[i - 1][j];
                    dp[i][pos] = Math.min(t, dp[i][pos]);
//                    }
                }
            }
        }

        // 答案就是dp[n - 1]数组里的最小值
        t = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (t > dp[n - 1][i]) t = dp[n - 1][i];
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(new D20201111_514().findRotateSteps("godding", "gd"));
    }
}
