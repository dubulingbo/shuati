package leetcode.icof;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-15 14:25
 * i believe i can i do
 */
public class T013 {
    private int stepSum;
    // 可以减少为两个方向，即向下和向右
    // 因为起点在左上角，且保证每个格子最多遍历一次，因此，向左和向上都是多余的
    private int[] dx = {0, 1};
    private int[] dy = {1, 0};
    private boolean[][] visited;

    public class Coo{
        int x,y;
        public Coo(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public int movingCount(int m, int n, int k) {
        // BFS + 剪枝
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        Queue<Coo> queue = new LinkedList<>();
        queue.add(new Coo(0,0));
        visited[0][0] = true;
        int res = 1;
        while(!queue.isEmpty()){
            Coo coo = queue.poll();
            for (int i = 0; i < 2; i++) {
                int newX = coo.x + dx[i];
                int newY = coo.y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]
                        && num2CharSum(newX) + num2CharSum(newY) <= k) {
                    res++;
                    visited[newX][newY] = true;
                    queue.add(new Coo(newX,newY));
                }
            }
        }

        return res;
    }

    public int movingCount_dfs(int m, int n, int k) {
        // DFS + 剪枝

        stepSum = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        dfs(m, n, 0, 0, k);

        return stepSum;
    }

    private void dfs(int m, int n, int x, int y, int k) {
        // 标记当前格子已经访问过
        visited[x][y] = true;

        // 开始向邻近的四个格子遍历
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                dfs(m, n, newX, newY, k);
            }
        }

        if (num2CharSum(x) + num2CharSum(y) <= k) {
            stepSum++;
            return;
        }

        // 取消该点 的标记
        visited[x][y] = false;
    }

    private int num2CharSum(int k) {
        char[] numArr = String.valueOf(k).toCharArray();
        int res = 0;
        for (char c : numArr) {
            res += c >= '0' && c <= '9' ? c - '0' : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T013().movingCount(3,3,1));
        System.out.println(new T013().movingCount(3,3,2));
        System.out.println(new T013().movingCount(3,3,0));
    }
}
