package leetcode.daily.y2020m11;

/**
 * @author DubLBo
 * @since 2020-11-15 12:14
 * i believe i can i do
 */
public class D20201115_402 {
    // 402. 移掉 K 位数字
    public String removeKdigits(String num, int k) {
        // 贪心 ：
        // 对于两个相同长度的数字序列，最左边不同的数字决定了这两个数字的大小，例如，对于 A = 1axxx，B = 1bxxx，
        // 如果 a > ba>b 则 A > B。
        // 若要使得剩下的数字最小，需要保证靠前的数字尽可能小。
        if (num.length() == 0 || num.length() == k) return "0";
        int prev = 0;
        StringBuilder sb = new StringBuilder("0");
        int delNum = 0;
        for (int i = 0; i < num.length(); i++) {
            if (delNum == k) { // 没有删除机会了，直接拼接在后面
                sb.append(num.charAt(i));
                // continue;
            } else {
                if (sb.charAt(prev) > num.charAt(i)) {
                    while (sb.charAt(prev) > num.charAt(i) && delNum < k) {
                        sb.deleteCharAt(prev--);
                        delNum++;
                    }
                }
                sb.append(num.charAt(i));
                prev++;
            }
        }

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        // 去掉尾部多出来的数
        while(sb.length() > num.length() - k){
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new D20201115_402().removeKdigits("1432219", 3));
        System.out.println(new D20201115_402().removeKdigits("10200", 1));
        System.out.println(new D20201115_402().removeKdigits("112", 1));
    }
}
