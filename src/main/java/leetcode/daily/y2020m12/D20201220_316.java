package leetcode.daily.y2020m12;

/**
 * @author habitplus
 * @since 2020-12-20 09:44
 */
public class D20201220_316 {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 1) return s;
        char[] chs = s.toCharArray();
        // 建立 hash 计数table：记录当前字符还剩多少可以使用
        int[] overage = new int[26];
        for (char c : chs) overage[c - 'a']++;

        // 标记栈中某个字母是否已经存在，初始时都不存在
        boolean[] exist = new boolean[26];

        // 辅助栈：存放已经排序好的字符
        char[] stack = new char[chs.length];
        int top = -1;
        for (char cur : chs) {
            int curIdx = cur - 'a';
            overage[curIdx]--;
            // 当前字符已经在栈中，则直接舍弃当前字符，进行下一个字符的判断
            if (exist[curIdx]) continue;

            // 栈顶元素比当前字符大，且在当前字符之后还有栈顶元素，则栈顶元素出栈
            while (top > -1 && stack[top] > cur && overage[stack[top] - 'a'] > 0) {
                // 栈顶元素出栈
                exist[stack[top] - 'a'] = false;
                top--;
            }

            // 当前元素进栈
            stack[++top] = cur;
            exist[curIdx] = true;
        }
        return new String(stack, 0, top + 1);
    }

    public static void main(String[] args) {
        System.out.println(new D20201220_316().removeDuplicateLetters("bcaaaabaaacaa"));
        System.out.println(new D20201220_316().removeDuplicateLetters("cbacdcbc"));
    }
}
