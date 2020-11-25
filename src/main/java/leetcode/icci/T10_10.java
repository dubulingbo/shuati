package leetcode.icci;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-11-03 20:02
 * i believe i can i do
 */
public class T10_10 {
    // 面试题 10.10. 数字流的秩
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(0);
        maxHeap.add(0);
        maxHeap.add(2);
        maxHeap.add(2);
        maxHeap.add(-1);
        maxHeap.add(6);

        StreamRank sr = new StreamRank();
        sr.track(-1);
        sr.track(-3);
        sr.track(3);
        sr.track(3);
        sr.track(2);
        sr.track(-4);
        sr.track(5);

        while (!maxHeap.isEmpty()) System.out.println(maxHeap.poll());
    }


}

// 二分查找
class StreamRank {

    private List<Integer> sortData;

    public StreamRank() {
        sortData = new ArrayList<>();
    }

    public void track(int x) {
        int k = Collections.binarySearch(sortData, x);
        if (k < 0) k = -k - 1;
        // 如此列表里的数据就已经有序了（升序）
        sortData.add(k, x);
    }

    public int getRankOfNumber(int x) {
        int ans = 0;
        for(int i = 0; i< sortData.size() && sortData.get(i) <= x; i++){
            ans++;
        }
        return ans;
    }
}


// 大顶堆 + 辅助栈
class StreamRank01 {

    // 大顶堆
    private PriorityQueue<Integer> maxHeap;
    // 辅助栈
    private Stack<Integer> assistStack;

    public StreamRank01() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        assistStack = new Stack<>();
    }

    public void track(int x) {
        maxHeap.add(x);
    }

    public int getRankOfNumber(int x) {
        int ans = maxHeap.size();

        while (!maxHeap.isEmpty() && maxHeap.peek() > x) {
//            int num = maxHeap.peek();
//            if (num > x) {
            assistStack.push(maxHeap.poll());
//            } else {
//                break;
//            }
        }
        ans -= assistStack.size();
        while (!assistStack.isEmpty()) maxHeap.add(assistStack.pop());
        return ans;
    }
}
