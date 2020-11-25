package leetcode.icof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-16 22:31
 * i believe i can i do
 */
public class T058I {
    public String reverseWords(String s) {
        // 双指针 + 逆序遍历
        s = s.trim();
        int i = s.length(), j = s.length() - 1;
        List<String> res = new ArrayList<>();
        while (j > -1) {
            // 搜索首个空格
            while (j > -1 && s.charAt(j) != ' ') j--;
            // 添加当前的单词到
            res.add(s.substring(j + 1, i));

            // 去掉多余的空格
            while (j > -1 && s.charAt(j) == ' ') j--;

            // 平移 i 指针指向下一个单词的尾部的下一个位置
            i = j + 1;

        }
        return String.join(" ", res);
    }

    public static void main(String[] args) {
        System.out.println(new T058I().reverseWords(" a good   example    "));
        System.out.println(new T058I().reverseWords("the sky is blue"));
        System.out.println(new T058I().reverseWords("  hello world!  "));
    }
}
