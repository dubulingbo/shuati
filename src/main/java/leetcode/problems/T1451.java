package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author DubLBo
 * @since 2020-11-08 14:42
 * i believe i can i do
 */
public class T1451 {
    public String arrangeWords(String text) {
        String[] ss = text.trim().toLowerCase().split(" ");
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String s = String.join(" ",ss);
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(new T1451().arrangeWords("Leetcode is cool"));
        System.out.println(new T1451().arrangeWords("Keep calm and code on"));
        System.out.println(new T1451().arrangeWords("To be or not to be"));
    }
}
