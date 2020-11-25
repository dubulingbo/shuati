package leetcode.icci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-27 15:15
 * i believe i can i do
 */
public class T08_09 {

    // 相当于栈，保存每次继续往里深入时的当前数据
    class Node {
        /**
         * 当前得到的字符串
         */
        private String cur;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String cur, int left, int right) {
            this.cur = cur;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 广度优先搜索
     *
     * @param n   括号的总对数
     * @param ans 存结果集
     */
    public void bfs(int n, List<String> ans) {
        Queue<Node> queue = new LinkedList<>();
        if (n > 0) {
            queue.offer(new Node("", n, n));
        }
        while (!queue.isEmpty()) {

            for (int i = queue.size(); i > 0; i--) {
                Node curNode = queue.poll();
                if (curNode.left == 0 && curNode.right == 0) {
                    // 左右括号都用完了，说明这就是一种情况，需保存起来
                    ans.add(curNode.cur);
                } else {
                    if (curNode.left > 0) { // 左括号剩余数大于零，先处理左括号 （保证每对括号的合法性）
                        queue.offer(new Node(curNode.cur + "(", curNode.left - 1, curNode.right));
                    }
                    if (curNode.right > 0 && curNode.left < curNode.right) {
                        // 右括号剩余数大于零，且左括号剩余数 < 右括号剩余数 （保证合法）
                        queue.offer(new Node(curNode.cur + ")", curNode.left, curNode.right - 1));
                    }
                }
            }
        }
    }


    /**
     * 回溯：深度优先搜索
     *
     * @param n      左、右括号一共各有多少个
     * @param left   左括号剩余数量
     * @param right  右括号剩余数量
     * @param curStr 当前字符串
     * @param ans    存所有可能的结果
     */
    public void dfs(int n, int left, int right, String curStr, List<String> ans) {

        if (left == 0 && right == 0) {
            ans.add(curStr);
            return;
        }

        if (left > 0) {
            // 左括号剩余数大于零，加入左括号进行递归
            dfs(n, left - 1, right, curStr + "(", ans);
        }

        if (right > 0 && left < right) {
            // 右括号剩余数大于零，且左括号剩余数要小于右括号的剩余数（这样就能保证右括号对应的左括号始终在前面）
            dfs(n, left, right - 1, curStr + ")", ans);
        }


    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs(n, n, n, "", res);
        return res;
    }

    public static void main(String[] args) {
        T08_09 test = new T08_09();
        long start, end;
        List<String> res1 = new ArrayList<>();
        List<String> res2 = new ArrayList<>();
//        start = System.currentTimeMillis();
//        test.dfs(20,20,20,"",res1);
//        end = System.currentTimeMillis();
//        System.out.println("DFS spends times : " + (end - start) + " ms");

        start = System.currentTimeMillis();
        test.bfs(10, res2);
        end = System.currentTimeMillis();
        System.out.println("BFS spends times : " + (end - start) + " ms");
//        System.out.println(res2);

    }


}
