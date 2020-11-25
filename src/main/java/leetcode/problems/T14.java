package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-09 22:00
 * i believe i can i do
 */
public class T14 {
    // 14. 最长公共前缀
    public String longestCommonPrefix01(String[] strs) {
        // 横向比较，即每次对比两个字符串，找出最长的前缀
        if (strs.length == 0) return "";
        int k = 0;
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (s.equals("")) break;
            s = commonPrefix(s, strs[i]);
        }
        return s;
    }

    public String longestCommonPrefix(String[] strs) {
        // 纵向比较，即每一轮都会比较每个字符的相同位置上的字符
        if (strs.length == 0) return "";
        int k = 0;
        String s = strs[0];
        for (int i = 0; ; i++) {
            if(i == strs.length){
                // 已经循环一轮了
                i = -1;
                k++;
                continue;
            }
            // 某个字符串为空 || k已经到达某个字符串的尾部 || 当前位置的字符不相同
            if (strs[i].equals("") || k > strs[i].length() - 1 || strs[i].charAt(k) != s.charAt(k)) break;
        }
        return s.substring(0,k);
    }

    private String commonPrefix(String s1, String s2) {
        if (s1.equals("") || s2.equals("")) return "";
        int k = 0;
        while (k < s1.length() && k < s2.length()) {
            if (s1.charAt(k) != s2.charAt(k)) break;
            k++;
        }
        return s1.substring(0, k);
    }

    public static void main(String[] args) {
//        String s = "123";
//        System.out.println(">>>>" + s.substring(0, 0).equals("") + "<<<<<<");

        System.out.println(new T14().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new T14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(new T14().longestCommonPrefix(new String[]{"dog"}));
    }
}
