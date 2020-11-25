package leetcode.problems;

import java.util.Stack;

/**
 * @author DubLBo
 * @since 2020-11-09 22:28
 * i believe i can i do
 */
public class T20 {
    // 20. 有效的括号
    // 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    // 有效字符串需满足：
    //      左括号必须用相同类型的右括号闭合。
    //      左括号必须以正确的顺序闭合。
    // 注意空字符串可被认为是有效字符串。
    public boolean isValid(String s) {
        // 辅助栈， 与右括号就出栈，并进行判断
        if(s.equals("")) return true;
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        char[] pi = {')',']','}'};
        for (char ch : chs) {
            switch (ch) {
                case '(':
                    stack.push(pi[0]);
                    break;
                case '[':
                    stack.push(pi[1]);
                    break;
                case '{':
                    stack.push(pi[2]);
                    break;
                default :
                    if (!stack.isEmpty()) {
                        char c = stack.pop();
                        if (c != ch) return false;
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T20().isValid("()[]{}"));
        System.out.println(new T20().isValid("([)]"));
        System.out.println(new T20().isValid("{[]}"));
        System.out.println(new T20().isValid("(]"));
    }
}
