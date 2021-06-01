package leetcode.daily.y2020m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DubLBo
 * @since 2020-10-22 13:57
 * i believe i can i do
 */
public class D20201022_763 {
    // 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
    // 同一个字母只会出现在其中的一个片段。
    // 返回一个表示每个字符串片段的长度的列表。
    public List<Integer> partitionLabels(String S) {
        // 贪心算法 + 双指针
//        Map<Character, Integer> lastIndex = new HashMap<>();
//
//        char[] chs = S.toCharArray();
//
//        for(int i=0;i<chs.length;i++) lastIndex.put(chs[i], i);
//
//        List<Integer> res = new ArrayList<>();
//        // 记录当前区间的最大下标
//        int maxIdx = lastIndex.get(chs[0]);
//        // 记录一个字符序列长度
//        int cnt = 1;
//
//        for(int i=1;i<chs.length;i++){
//            //判断是否可以在当前字符后截断：
//            // chs[..i-1]中字符的最大最后出现的下标  < i
//            if(maxIdx < i){
//                res.add(cnt);
//                maxIdx = lastIndex.get(chs[i]);
//                cnt = 1;
//            }else{
//                maxIdx = Math.max(maxIdx, lastIndex.get(chs[i]));
//                cnt++;
//            }
//        }
//        res.add(cnt);
//        return res;

        // 优化：代码层面的优化
        Map<Character, Integer> lastIndex = new HashMap<>();

        char[] chs = S.toCharArray();

        for (int i = 0; i < chs.length; i++) lastIndex.put(chs[i], i);

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < chs.length; i++) {
            //判断是否可以在当前字符后截断：
            // chs[..i-1]中字符的最大最后出现的下标  = i
            end = Math.max(end, lastIndex.get(chs[i]));
            if (end == i) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
