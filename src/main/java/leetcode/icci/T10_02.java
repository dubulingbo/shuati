package leetcode.icci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DubLBo
 * @since 2020-10-29 22:14
 * i believe i can i do
 */
public class T10_02 {

    // 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
    public List<List<String>> groupAnagrams(String[] strs) {
        // 存储有序字符串下的源字符串
        Map<String, List<String>> wordMap = new HashMap<>(strs.length);

//        for (String str : strs) {
//            char[] chs = str.toCharArray();
//            Arrays.sort(chs);
//            String key = String.valueOf(chs);
//
////            wordMap.computeIfAbsent(key, unused -> new ArrayList<>()).add(str);
//
//            if (!wordMap.containsKey(key)) {
//                wordMap.put(key, new ArrayList<>());
//            }
//            wordMap.get(key).add(str);
//        }

        for (String str : strs) {
            int[] count = new int[26];
            char[] chs = str.toCharArray();
            for (char ch : chs) {
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder(str.length());
            for(int i =0 ;i<count.length; i++){
                if(count[i] == 1) sb.append((char)('a'+i));
                else if (count[i] > 1) sb.append((char)('a'+i)).append(count[i]);
            }
            String key = sb.toString();
            if (!wordMap.containsKey(key)) {
                wordMap.put(key, new ArrayList<>());
            }
            wordMap.get(key).add(str);

        }


        return new ArrayList<>(wordMap.values());
    }

}
