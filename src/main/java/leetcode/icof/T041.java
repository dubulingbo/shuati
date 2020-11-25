package leetcode.icof;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author DubLBo
 * @since 2020-10-15 09:56
 * i believe i can i do
 */
public class T041 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        System.out.println(medianFinder.findMedian());
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0;i<10;i++){
            medianFinder.addNum(random.nextInt(10));
            System.out.println(medianFinder.findMedian());
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {

    /**
     * 若 总数 为偶数，两个堆存储的数量相等
     * 若 总数 为奇数，小顶堆存储的数量 = 大顶堆存储的数量 + 1
     * 始终会保持小顶堆最多只会比大顶堆多一个
     */
    private PriorityQueue<Integer> minHeap; // 小顶堆，存储一半较大的数
    private PriorityQueue<Integer> maxHeap; // 大顶堆，存储一半较小的数

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
//        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 降序排列
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            // 先加到大顶堆，再弹出大顶堆的堆顶元素到小顶堆
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            // 先加到小顶堆，再弹出小顶堆的堆顶元素到大顶堆
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.isEmpty()){
            return 0;
        }
        return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) * 0.5 : minHeap.peek();
    }
}
