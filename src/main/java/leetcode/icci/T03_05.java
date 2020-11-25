package leetcode.icci;

import java.util.Stack;

/**
 * @author DubLBo
 * @since 2020-10-23 11:53
 * i believe i can i do
 */
public class T03_05 {


}

class SortedStack {

    // 维持一个单调栈：从顶到底，单调递增
    private Stack<Integer> data;
    private Stack<Integer> assist;

    public SortedStack() {
        data = new Stack<>();
        assist = new Stack<>();
    }

    public void push(int val) {
        if (data.isEmpty()) {
            data.push(val);
        } else {
            while (!data.isEmpty() && data.peek() < val) {
                assist.push(data.pop());
            }

            data.push(val);

            // 调整回来
            while (!assist.isEmpty()) data.push(assist.pop());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
        }
    }

    public int peek() {
        return data.isEmpty() ? -1 : data.peek();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
