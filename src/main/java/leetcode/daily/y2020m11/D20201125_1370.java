package leetcode.daily.y2020m11;

public class D20201125_1370 {
    // 1370. 上升下降字符串
    public String sortString(String s) {
        // hash 计数
        int[] alpha = new int[26];
        int maxTimes = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            alpha[i]++;
            if (alpha[i] > maxTimes) maxTimes = alpha[i];
        }

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxTimes; i++) {
            // 严格递增序列
            if (flag) {
                for (int j = 0; j < 26; j++) {
                    if (alpha[j] == 0) continue;
                    sb.append((char) ('a' + j));
                    alpha[j]--;
                }
            } else {
                for (int j = 25; j >= 0; j--) {
                    if (alpha[j] > 0) {
                        sb.append((char) ('a' + j));
                        alpha[j]--;
                    }
                }
            }
            flag = !flag;
        }
        return sb.toString();
    }
}
