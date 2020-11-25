package leetcode.icci;

import java.util.*;


/**
 * @author DubLBo
 * @since 2020-10-27 16:30
 * i believe i can i do
 */
public class T08_07 {
    // 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
    public String[] permutation(String s) {
        if (s.length() == 0) return new String[0];
        char[] chs = s.toCharArray();
        List<String> list = new ArrayList<>();

        bfs(chs, list);
        return list.toArray(new String[0]);
    }

    private void bfs(char[] chs, List<String> arrayList) {

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while (!queue.isEmpty()) {

            for (int i = queue.size(); i > 0; i--) {
                String s = queue.poll();
                if(s.length() == chs.length){
                    arrayList.add(s);
                    continue;
                }

                for (char ch : chs) {
                    String tmp = String.valueOf(ch);
                    if (!s.contains(tmp)) {
                        queue.offer(s + tmp);
                    }
                }
            }
        }
    }

    private void dfs(char[] chs, String curStr, List<String> arrayList) {
        if (curStr.length() == chs.length) arrayList.add(curStr);

        for (char ch : chs) {
            String s = String.valueOf(ch);
            if (!curStr.contains(s)) {
                dfs(chs, curStr + s, arrayList);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T08_07().permutation("qwe")));
    }
}
