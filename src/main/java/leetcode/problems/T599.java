package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-14 10:35
 * i believe i can i do
 */
public class T599 {
    // 599. 两个列表的最小索引总和
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> resList = new ArrayList<>();

        // 为 list1 建立 hash 索引
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);

        int index = 0;
        int idxSum = -1;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (idxSum == -1 || idxSum > i + map.get(list2[i])) {
                    index = 0;
                    resList.add(index++, list2[i]);
                    idxSum = i + map.get(list2[i]);
                } else if (idxSum == i + map.get(list2[i])) {
                    // 存在相等的下标和
                    resList.add(index++, list2[i]);
                }
            }
        }

        String[] res = new String[index];
        for(int i = 0;i<index;i++){
            res[i] = resList.get(i);
        }
        return res;
    }

}
