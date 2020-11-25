package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-15 15:57
 * i believe i can i do
 */
public class T1422 {
    // 1422. 分割字符串的最大得分
    public int maxScore(String s) {
        // 记录右边 1 的总数
        int right = 0;
        // 记录左边零的总数
        int left = 0;
        char[] chs = s.toCharArray();
        // 先统计 1 的总个数
        for (char c : chs) right += c == '1' ? 1 : 0;

        int ans = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            if (chs[i] == '0') left++;
            else right--;
            ans = Math.max(left + right, ans);
        }
        return ans;
    }

}
