package leetcode.daily.y2020m11;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-11-14 09:29
 * i believe i can i do
 */
public class D20201114_1122 {
    //
    public int[] relativeSortArray01(int[] arr1, int[] arr2) {
        // 计数排序 + 升序排序
        if (arr2.length == 0) {
            Arrays.sort(arr1);
            return arr1;
        }
        HashSet<Integer> hash = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // 以 arr2 建立 hash表
        for (int i : arr2) hash.add(i);

        // 统计 arr1 中出现在 arr2 中的元素的次数，并且在不在 arr2 中的元素移到 arr1 数组的后面部分
        int left = 0, right = arr1.length - 1;
        while (left <= right) {
            if (hash.contains(arr1[left])) {
                map.put(arr1[left], map.getOrDefault(arr1[left], 0) + 1);
                left++;
            } else {
                int t = arr1[left];
                arr1[left] = arr1[right];
                arr1[right] = t;
                right--;
            }
        }

        // 在arr2里面的数保持原序
        left = 0;
        for (int k : arr2) {
            int times = map.get(k);
            for (int j = 0; j < times; j++) arr1[left++] = k;
        }

        // 不在 arr2 里面的数升序排列在 arr1 后面部分
        Arrays.sort(arr1, left, arr1.length);
        return arr1;
    }

    public int[] relativeSortArray02(int[] arr1, int[] arr2) {
        // 自定义排序规则，注意到元素的大小不会超过 1000

        // 在 arr2 中的元素以下标值作为排序依据，即下标小的排在数组前面（保持原序）
        HashMap<Integer, Integer> rank = new HashMap<>();
        // 以 arr2 建立 hash rank表
        for (int i = 0; i < arr2.length; i++) rank.put(arr2[i], i);

        List<Integer> assList = new ArrayList<>();
        for (int i : arr1) assList.add(i);

        Collections.sort(assList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (rank.containsKey(o1) || rank.containsKey(o2)) {
                    return rank.getOrDefault(o1, 1003).compareTo(rank.getOrDefault(o2, 1003));
                }
                return o1.compareTo(o2);
            }
        });

        return assList.stream().mapToInt(Integer::valueOf).toArray();
//        for(int i=0;i<assList.size();i++) arr1[i] = assList.get(i);
//        return arr1;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 优化：计数排序（桶排序）
        int[] bucket = new int[1001];

        for (int i : arr1) bucket[i]++;

        int k = 0;
        for (int i : arr2) {
            while (bucket[i] > 0) {
                arr1[k++] = i;
                bucket[i]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (bucket[i] > 0) {
                arr1[k++] = i;
                bucket[i]--;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new D20201114_1122().relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
