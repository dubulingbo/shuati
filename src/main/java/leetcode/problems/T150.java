package leetcode.problems;

import java.util.Stack;

public class T150 {
    // 150. 逆波兰表达式求值
    public int evalRPN01(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            int a, b;
            switch (s) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    // parseInt() 要比 valueOf() 快！！！
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    public int evalRPN(String[] tokens) {
        int[] nums = new int[tokens.length];
        int right = 0;

        for (String s : tokens) {
            switch (s) {
                case "+":
                    nums[right - 2] += nums[right - 1];
                    right--;
                    break;
                case "-":
                    nums[right - 2] -= nums[right - 1];
                    right--;
                    break;
                case "*":
                    nums[right - 2] *= nums[right - 1];
                    right--;
                    break;
                case "/":
                    nums[right - 2] /= nums[right - 1];
                    right--;
                    break;
                default:
                    nums[right] = Integer.parseInt(s);
                    right++;
                    break;
            }
        }
        return right == 0 ? 0 : nums[right - 1];
    }

}
