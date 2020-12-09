package leetcode.problems;


public class T43 {
    // 43. 字符串相乘
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if (l1 == 0 || l2 == 0) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (l1 < l2) return multiply(num2, num1);

        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int[] res = new int[l1 + l2];
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int startIdx = res.length - 1;
        for (int i = l2 - 1; i >= 0; i--) {
            int tmpIdx = startIdx;
            int x = number[chs2[i] - '0'];
            for (int j = l1 - 1; j >= 0; j--) {
                int k = number[chs1[j] - '0'] * x + res[tmpIdx];
                res[tmpIdx--] = k % 10;
                k /= 10;
                res[tmpIdx] += k;
            }
            startIdx--;
        }

        startIdx = res[0] == 0 ? 1 : 0;
//        startIdx = 0;
//        while(startIdx < res.length && res[startIdx] == 0) startIdx++;
        StringBuilder sb = new StringBuilder();
        while (startIdx < res.length) sb.append(res[startIdx++]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T43().multiply("123131313131", "45600000"));
    }
}
