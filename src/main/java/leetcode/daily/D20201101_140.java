package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-01 13:37
 * i believe i can i do
 */
public class D20201101_140 {
    // 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
    // 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
    // 说明：
    //      分隔时可以重复使用字典中的单词。
    //      你可以假设字典中没有重复的单词。
    // 链接：https://leetcode-cn.com/problems/word-break-ii
    private HashSet<String> words;
    //    private String mainStr;
    private List<String> res;
    List<String> sentence = new ArrayList<>();
    // canBreak[i] 从 i 开始后的字符串不能匹配到 words 中的单词
    private boolean[] cannotBreak;

    public List<String> wordBreak(String s, List<String> wordDict) {
        // DFS + 剪枝（在回溯阶段记录不能从 start开始不能完全匹配的情况）
        words = new HashSet<>(wordDict);
//        mainStr = s;
        res = new ArrayList<>();
        cannotBreak = new boolean[s.length()];
//        canBreak[0] = true;
        // 从第一个字符开始
        dfs(0, s);
        return res;
    }

    /**
     * 深度优先搜索
     *
     * @param start 字符开始位置
//     * @param end   字符结尾的下一个位置，两者组合起来的是 mainStr 中的子字符串，即 mainStr.substring(start,end)
     */
    private void dfs(int start, String mainStr) {
        int curResSize = res.size(); // 记录当前的结果列表的容量。如果此次匹配成功，size应该会 +1；
        if (start == mainStr.length()) {
            // 说明已经找到了一种可能的组合
            res.add(String.join(" ", sentence));
            return;
        }

        if(!cannotBreak[start]){
            for (int i = start + 1; i <= mainStr.length(); i++) {
                String s = mainStr.substring(start, i);
                if (words.contains(s)) {
                    // 当前字符串处于 字典中
                    sentence.add(s);
                    // 从下一个 字符开始搜索
                    dfs(i, mainStr);
                    // 移除上一个字符串
                    sentence.remove(sentence.size() - 1);
                }
            }
        }
        cannotBreak[start] = res.size() == curResSize;
    }

    public static void main(String[] args) {
        List<String> ss = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        System.out.println(ss);
//        HashSet<String> set = new HashSet<>(ss);
//        System.out.println(set);

        System.out.println(new D20201101_140().wordBreak("catsanddog", ss));
    }
}
