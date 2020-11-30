package leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;

public class D20201130_767 {
    // 767. 重构字符串
    public String reorganizeString(String S) {
        // 按字母的出现次数进行降序排序
        // 贪心：依次安排出现次数最多的字母，先放下标为偶数的位置，因为偶数位置永远不会小于奇数位置
        if (S.length() <= 1) return S;
        // 存储 k：Character，v：occurTimes
        int[][] map = new int[26][2];
        char[] chs = S.toCharArray();
        int maxNum = 0;
        for (int i = 0; i < map.length; i++) map[i][0] = i;

        for (char c : chs) {
            int idx = c - 'a';
            map[idx][1]++;
            if (map[idx][1] > maxNum) maxNum = map[idx][1];
        }

//        if (len % 2 == 0 && maxNum > len / 2) return "";
//        if (len % 2 != 0 && maxNum > len / 2 + 1) return "";
        // 其实可以不用区分奇偶长度，直接大于 (len+1) / 2
        // 不能组成满足题目的字符串
        if (maxNum > (chs.length + 1) / 2) return "";

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        // 重排 chs
        // 开始从偶数位置开始填
        int k = 0;
        for (int[] m : map) {
            for (int n = m[1]; n > 0; n--) {
                chs[k] = (char) ('a' + m[0]);
                k += 2;
                // 从奇数位置开始填
                if (k >= chs.length) k = 1;
            }
        }

        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(new D20201130_767().reorganizeString("aaab"));
        System.out.println(new D20201130_767().reorganizeString("aab"));
    }
}
