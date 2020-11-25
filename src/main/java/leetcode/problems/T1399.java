package leetcode.problems;

public class T1399 {
    // 1399. 统计最大组的数目
    public int countLargestGroup(int n) {
        // 递推 + 数组遍历
        // sum[i] 表示 i 的十进制中各位数和
        int[] sum = new int[n + 1];
        // 记录 位数和 到 出现次数 的映射
        int[] map = new int[37];

        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i / 10] + i % 10;
            map[sum[i]]++;
        }

        // 记录各种位数和出现次数的最大值
        int maxTimes = 0;
        for (int i : map) {
            if (i > maxTimes) maxTimes = i;
        }

        // 统计出现次数为 maxTimes 的个数
        int cnt = 0;
        for (int i = 0; i < 37; i++) {
            if (map[i] == maxTimes) cnt++;
        }

        return cnt;
    }


}
