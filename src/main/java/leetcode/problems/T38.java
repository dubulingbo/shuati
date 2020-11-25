package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 13:26
 * i believe i can i do
 */
public class T38 {
    // 38. 外观数列
    public String countAndSay(int n) {
        // 递归 + 双指针（快慢指针）遍历
        if (n == 1) return "1";

        // 获取上一个（第 n-1 个）字符串
        String preStr = countAndSay(n - 1);
        // 第 n 个字符串
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= preStr.length(); i++) {
            if (i == preStr.length()) {
                sb.append(i - j).append(preStr.charAt(i-1));
            } else if (preStr.charAt(i - 1) != preStr.charAt(i)) {
                sb.append(i - j).append(preStr.charAt(i - 1));
                j = i;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T38().countAndSay(5));
    }
}
