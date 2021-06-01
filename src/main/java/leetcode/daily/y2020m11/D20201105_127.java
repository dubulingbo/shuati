package leetcode.daily.y2020m11;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-11-05 09:11
 * i believe i can i do
 */
public class D20201105_127 {
    // 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
    //      每次转换只能改变一个字母。
    //      转换过程中的中间单词必须是字典中的单词。
    //
    // 说明:
    // 如果不存在这样的转换序列，返回 0。
    // 所有单词具有相同的长度。
    // 所有单词只由小写字母组成。
    // 字典中不存在重复的单词。
    // 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    //
    //链接：https://leetcode-cn.com/problems/word-ladder
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        // BFS : 时间复杂度：O(N * wordLen) N为单词列表的长度，wordLen为单词的字符数
//        if (wordList.size() == 0 || beginWord.equals(endWord)) return 0;
//        Queue<String> queue = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//        Map<String, Integer> stepMap = new HashMap<>();
//
//        int ans = 0;
//        queue.add(beginWord);
//        stepMap.put(beginWord, 1);
//        visited.add(beginWord);
//
//        while (!queue.isEmpty()) {
//            String word = queue.poll();
//            if(word.equals(endWord)){
//                ans = stepMap.get(endWord);
//                break;
//            }
//            int step = stepMap.get(word);
//
//            for (String s : wordList) {
//                if (!visited.contains(s) && changeOne(word, s)) {
//                    stepMap.put(s, step + 1);
//                    visited.add(s);
//                    queue.add(s);
//                }
//            }
//        }
//        return ans;
//    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS : 时间复杂度：O(26 * wordLen)，wordLen为单词的字符数
        // 枚举所有单词可能的变换，一共有 26 * wordLen 种
        if (wordList.size() == 0 || beginWord.equals(endWord)) return 0;

        // 建立单词的 hash table，便于寻找某个单词
        Set<String> hash = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int step = 1;
        queue.add(beginWord);
        visited.add(beginWord);
        int wordLen = beginWord.length();
        while (!queue.isEmpty()) {

            for (int k = queue.size(); k > 0; k--) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    // 找到了目标单词，直接结束所有循环，返回答案
                    return step;
                }

                // 开始枚举 word 的所有可能的变换
                char[] chs = word.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    // 暂存当前字符，或许还要还原该位置上的字符
                    char original = chs[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        // 如果是原始字符，直接进行下一回合的循环
                        if (c == original) continue;

                        chs[i] = c;
                        String nextStr = String.valueOf(chs);
                        // 还未加入过队列 && 这次变换在单词字典列表里面，则加入队列
                        if (!visited.contains(nextStr) && hash.contains(nextStr)) {
                            queue.add(nextStr);
                            visited.add(nextStr);
                        }

                        // 还原字符，方便进行下一个位置的变换，保证每次只变换了一个字符
                        chs[i] = original;
                    }
                }
            }
            // 本层遍历完，步数（层数）加一
            step++;
        }
        return 0;
    }

    /**
     * 判断 word 是否只改变了 一个字符 到 s
     *
     * @param word 源字符串
     * @param s    目标字符串
     * @return 是否能进行转换
     */
    private boolean changeOne(String word, String s) {
        if (word.length() != s.length()) return false;
        // 标记不相同的字符的个数
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            count += word.charAt(i) != s.charAt(i) ? 1 : 0;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new D20201105_127().ladderLength("hit", "cog", list));

        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println(c);
        }
    }
}
