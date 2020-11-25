package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-04 14:01
 * i believe i can i do
 */
public class T537 {
    public String complexNumberMultiply(String a, String b) {
        int[] i1 = detach(a);
        int[] i2 = detach(b);
        int x = i1[0] * i2[0] - i1[1] * i2[1];
        int y = i1[0] * i2[1] + i1[1] * i2[0];
        return x + "+" + y + "i";
    }

    /**
     * 分解复数 a+bi 的实数值 和 虚数值
     *
     * @param s 要解析的字符串，满足 a+bi结构
     * @return 实数值和虚数值
     */
    private int[] detach(String s) {
        int addIndex = s.indexOf("+");
        int a = Integer.parseInt(s.substring(0, addIndex));
        int b = Integer.parseInt(s.substring(addIndex + 1, s.length() - 1));
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println(new T537().complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(new T537().complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
