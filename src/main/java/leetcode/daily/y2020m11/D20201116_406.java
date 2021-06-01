package leetcode.daily.y2020m11;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-11-16 10:04
 * i believe i can i do
 */
public class D20201116_406 {
    // 406. 根据身高重建队列
    public int[][] reconstructQueue(int[][] people) {
        // 先对 h 关键字进行降序排列， h相同时，按 k 关键字进行升序排列
        if(people.length == 0) return new int[0][];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });

        // 直接将 升高为 h 的人放在 k+1 位置上，因为数组下标从一开始，所以直接放入 k 位置，
        // 这里还用到了链表的插入，即，如果 k 位置已经被占了，那么就在它的前一个位置插入，就相当于，在链表的第 k+1 个位置进行插入
        List<int[]> res = new ArrayList<>(people.length);
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[0][]);
    }
}
