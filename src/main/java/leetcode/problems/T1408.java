package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-04 11:11
 * i believe i can i do
 */
public class T1408 {
    // 1408. 数组中的字符串匹配
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        if(words.length == 0) return res;
        StringBuilder sb = new StringBuilder();
        for (String s : words) sb.append(s).append("#");

        String target = sb.toString();
        for (String word : words) {
            if (target.lastIndexOf(word) != target.indexOf(word)) res.add(word);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T1408().stringMatching(new String[]{"mass","as","hero","superhero"}));
        System.out.println(new T1408().stringMatching(new String[]{"leetcode","et","code"}));
        System.out.println(new T1408().stringMatching(new String[]{"blue","green","bu"}));
    }
}
