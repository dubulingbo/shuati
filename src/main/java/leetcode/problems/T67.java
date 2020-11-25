package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 14:38
 * i believe i can i do
 */
public class T67 {
    // 67. 二进制求和
    public String addBinary(String a, String b) {
        // 双指针
        // O(m+n);
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                k += (b.charAt(j) - '0');
                j--;
            } else if (j < 0) {
                k += (a.charAt(i) - '0');
                i--;
            } else {
                k += (a.charAt(i) - '0' + b.charAt(j) - '0');
                i--;
                j--;
            }
            sb.append(k % 2);
            k /= 2;
        }

        if(k != 0) sb.append(k);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new T67().addBinary("11","1"));
        System.out.println(new T67().addBinary("1010","1011"));
        System.out.println(new T67().addBinary("101111","10"));
        System.out.println(Math.PI);
    }
}
