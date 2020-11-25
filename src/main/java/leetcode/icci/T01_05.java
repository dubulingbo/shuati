package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-10-21 18:33
 * i believe i can i do
 */

public class T01_05 {
    // 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
    // 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len2 > len1) return oneEditAway(second, first);

        // 保持第一个比第二个长
        for (int i = 0; i < len2; i++){
            // 找出第一个不相等的字符，再比较后面的子字符串：
            // 1. 若 first 的长度 > second 的长度 ，比较first的i+1及后面的字符 与 second的i及后面的字符
            // 2. 若 first 的长度 = second 的长度 ，比较first的i+1及后面的字符 与 second的i+1及后面的字符
            if (first.charAt(i) != second.charAt(i)){
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }
}
