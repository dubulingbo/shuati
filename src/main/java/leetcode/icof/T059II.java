package leetcode.icof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-17 14:53
 * i believe i can i do
 */
public class T059II {
    public static void main(String[] args) {

    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
class MaxQueue {
    // 单调队列
    Deque<Integer> dullQueue;
    // 数据队列（原始队列）
    Queue<Integer> dataQueue;

    public MaxQueue() {
        dullQueue = new LinkedList<>();
        dataQueue = new LinkedList<>();
    }

    public int max_value() {
        if(dullQueue.isEmpty()){
            return -1;
        }
        return dullQueue.peekFirst();
    }

    public void push_back(int value) {
        // 插入单调队列
        while(!dullQueue.isEmpty() && dullQueue.peekLast() < value){
            dullQueue.pollLast();
        }
        dullQueue.offerLast(value);

        // 在队尾添加一个元素
        dataQueue.offer(value);
    }

    public int pop_front() {
        if(dataQueue.isEmpty()){
            return -1;
        }
        int e = dataQueue.poll();
        // 是否当前出队的元素是最大值
        if(!dullQueue.isEmpty() && dullQueue.peekFirst() == e){
            dullQueue.pollFirst();
        }

        return e;
    }
}
