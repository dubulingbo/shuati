package leetcode.problems;

public class T151 {
    // 151. 翻转字符串里的单词
    // 给定一个字符串，逐个翻转字符串中的每个单词。
    //
    //    说明：
    //
    //    无空格字符构成一个 单词 。
    //    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    //    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int right = chs.length - 1;
        int left = chs.length - 1;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            // 单词后面的空格
            while (left >= 0 && chs[left] == ' ') left--;

            // 获取单词
            if (left >= 0) {
                right = left;
                // while(left >= 0 && chs[left] != ' ') left--;
                left = s.lastIndexOf(' ', right);
//                System.out.println("right = " + right + ", left = " + left);
                sb.append(s, left + 1, right + 1);
                sb.append(' ');
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T151().reverseWords("   i   love   you and  yy4480   "));
    }
}
