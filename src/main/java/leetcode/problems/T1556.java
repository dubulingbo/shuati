package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 22:30
 * i believe i can i do
 */
public class T1556 {
    // 1556. 千位分隔数
    // 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        int len = 0;
        if (s.length() < 3) len = s.length();
        else if (s.length() % 3 == 0) len = s.length() + s.length() / 3 - 1;
        else len = s.length() + s.length() / 3;

        char[] ans = new char[len];
        int k = len - 1;
        for (int i = s.length()-1; i >= 0; i--){
            ans[k--] = s.charAt(i);
            if((s.length() - i) % 3 == 0 && k >= 0) ans[k--] = '.';
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(new T1556().thousandSeparator(123456789));
        System.out.println(new T1556().thousandSeparator(0));
        System.out.println(new T1556().thousandSeparator(12));
        System.out.println(new T1556().thousandSeparator(1358423586));
        System.out.println(new T1556().thousandSeparator(1234));
    }
}
