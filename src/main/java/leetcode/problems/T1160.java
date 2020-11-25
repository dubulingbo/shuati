package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DubLBo
 * @since 2020-11-11 19:42
 * i believe i can i do
 */
public class T1160 {
    // 1160. 拼写单词
    public int countCharacters(String[] words, String chars) {
        // hash 计数
        int[] charTable = new int[26];
        for (int i = 0; i < chars.length(); i++) charTable[chars.charAt(i) - 'a']++;

        int ans = 0;
        for (String word : words) {
            // 统计待测字符串中的hash table
            HashMap<Character, Integer> hash = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                hash.put(c, hash.getOrDefault(c, 0) + 1);
            }

            boolean success = true;

            for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
                char key = entry.getKey();
                if (entry.getValue() > charTable[key - 'a']) {
                    success = false;
                    break;
                }
            }

            if (success) ans += word.length();
        }
        return ans;
    }
}
