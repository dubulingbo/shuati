package leetcode.icci;

import java.util.Stack;

/**
 * @author DubLBo
 * @since 2020-10-22 19:18
 * i believe i can i do
 */
public class T03_01 {

}

class TripleInOne {

    private int[] data;
    private int stackSize;
    private int[] top;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        data = new int[this.stackSize * 3];
        this.top = new int[3];
        top[0] = 0;
        top[1] = stackSize;
        top[2] = stackSize * 2;
    }

    public void push(int stackNum, int value) {
        if (top[stackNum] - (stackNum + 1) * stackSize != 0) {
            // 栈不满：
            data[top[stackNum]++] = value;
        }
    }

    public int pop(int stackNum) {
        return isEmpty(stackNum) ? -1 : data[--top[stackNum]];
    }

    public int peek(int stackNum) {
        return isEmpty(stackNum) ? -1 : data[top[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        if (top[stackNum] - stackNum * stackSize == 0) {
            // 栈为空
            return true;
        }
        return false;
    }
}
