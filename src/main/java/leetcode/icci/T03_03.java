package leetcode.icci;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author DubLBo
 * @since 2020-10-22 20:03
 * i believe i can i do
 */
public class T03_03 {

}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */
class StackOfPlates {

    private int capacity;
    private LinkedList<Stack<Integer>> stackList;

    public StackOfPlates(int cap) {
        capacity = cap;
        stackList = new LinkedList<>();
    }

    public void push(int val) {
        if (capacity <= 0) { // 指定的容量为0，不叠任何盘子
            return;
        }

        // 还没有创建栈 or 最后一个栈已经存满
        if (stackList.size() == 0 || stackList.getLast().size() == capacity) {
            stackList.add(new Stack<>());
        }
        stackList.getLast().push(val);
    }

    public int pop() {
        if (stackList.size() == 0) {
            return -1;
        }

        Stack<Integer> stack = stackList.getLast();
        int e = stack.pop();
        if (stack.isEmpty()) { // 移除该栈
            stackList.removeLast();
        }
        return e;
    }

    public int popAt(int index) {
        if (stackList.size() - 1 < index) {
            return -1;
        }
        Stack<Integer> stack = stackList.get(index);
        int e = stack.pop();
        if (stack.isEmpty()) {
            stackList.remove(index);
        }
        return e;
    }
}
