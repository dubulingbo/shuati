package leetcode.daily.y2020m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author DubLBo
 * @since 2020-10-31 08:57
 * i believe i can i do
 */
public class D20201031_381 {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(9);
        set.add(6);
        set.add(8);
        set.add(5);

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}

class RandomizedCollection {

    // 存储容器中的数据
    ArrayList<Integer> data;
    // 容器中某个数对应的下标，可能会有多个相同的数
    HashMap<Integer, HashSet<Integer>> indexMap;
    private HashSet<Integer> indexSet;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        indexMap = new HashMap<>();
        data = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection.
     * Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        data.add(val);
        // 获取 val 对应的下标集合；若没有，则新建一个 HashSet 用来除当前数的下标
        HashSet<Integer> indexSet = indexMap.getOrDefault(val, new HashSet<>());
        // 将当前数的下标加入【下标集合】
        indexSet.add(data.size() - 1);
        indexMap.put(val, indexSet);
        // 当前数的【下标集合】只有一个元素，说明刚插入的是一个全新的数
        return indexSet.size() == 1;
    }

    /**
     * Removes a value from the collection.
     * Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        // 没有当前的数，直接返回 false
        if (!indexMap.containsKey(val)) {
            return false;
        }

        // 思路：每次只能删除 data列表 中最后一个元素，即让最后元素替换掉当前数
        // 得到当前数的【下标集合】
        HashSet<Integer> indexSet = indexMap.get(val);
        // 拿到集合中的【val 在【data列表】中的一个下标值】
        int index = indexSet.iterator().next();
        if (index == data.size() - 1) {
            // 要移出的数刚好是 data列表 中的最后一个数
            indexMap.get(val).remove(index);
            data.remove(index);
        } else {
            // 获取 data列表 中的 最后一个数
            int lastNum = data.get(data.size() - 1);
            // 用最后的数替换当前的数
            data.set(index, lastNum);

            // 移除 val 对应的下标集合中的 index 下标
            indexMap.get(val).remove(index);
            // 修改 lastNum 的 下标集合 中的 data.size()-1 为 index；
            // 做法是：先删除 data.size()-1 ，再添加 index
            indexMap.get(lastNum).remove(data.size() - 1);
            indexMap.get(lastNum).add(index);
        }
        // 判断是否 val 只存在唯一一个在 data列表中
        if (indexMap.get(val).size() == 0) {
            indexMap.remove(val);
        }
        // 从 data列表 中删除最后一个数
        data.remove(data.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return data.get((int) (Math.random() * data.size()));
    }
}
