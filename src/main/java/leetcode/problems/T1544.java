package leetcode.problems;

import java.util.Stack;

/**
 * @author DubLBo
 * @since 2020-11-11 15:09
 * i believe i can i do
 */
public class T1544 {
    // 1544. 整理字符串
    public String makeGood(String s) {
        // 辅助栈
        Stack<Character> stack = new Stack<>();
        char tmp;

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            tmp = stack.peek();
            if (tmp + 32 == s.charAt(i) || tmp - 32 == s.charAt(i)) {
                // 找到了匹配的字符
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String makeGood01(String s) {
        // StringBuilder 模拟栈

        StringBuilder ans = new StringBuilder();
        // 指向答案容器的最后一个字符
        int pre = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 前面的字符不为空 || 最近的一个字符与当前字符互为大小写
            if (ans.length() > 0 && (ans.charAt(pre) == c + 32 || ans.charAt(pre) == c - 32)) {
                // 从答案容器中删除最近的一个字符，pre指针后退 1
                ans.deleteCharAt(pre);
                pre--;
            } else {
                ans.append(c);
                pre++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T1544().makeGood01("NAanorRoOrROwnTNW"));
        System.out.println(new T1544().makeGood01("leEeetcode"));
    }
}
