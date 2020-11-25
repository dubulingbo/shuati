package contest.ICPC_2020_01.I;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-10-25 12:59
 * i believe i can i do
 */
public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            maze[i] = tmp.toCharArray();
        }


//        System.out.println(n + " " + m);
//        System.out.println(Arrays.deepToString(maze));

        boolean[][] success = new boolean[n][m];
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        char[] ff = {'W', 'S', 'A', 'D'};

        // 遍历最外围的列
        for (int i = 0; i < n; i++) {
            if (maze[i][0] == 'A') {
                ans++;
                queue.offer(new int[]{i, 0});
                success[i][0] = true;
            }

            if (maze[i][m - 1] == 'D') {
                ans++;
                queue.offer(new int[]{i, m - 1});
                success[i][m - 1] = true;
            }
        }

        // 遍历最外围的行
        for (int i = 0; i < m; i++) {
            if (maze[0][i] == 'W') {
                ans++;
                queue.offer(new int[]{0, i});
                success[0][i] = true;
            }

            if (maze[n - 1][i] == 'S') {
                ans++;
                queue.offer(new int[]{n - 1, i});
                success[n - 1][i] = true;
            }
        }


        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] dd = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = dd[0] + dx[j];
                    int newY = dd[1] + dy[j];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && !success[newX][newY] && maze[newX][newY] == ff[j]) {
                        queue.offer(new int[]{newX, newY});
                        success[newX][newY] = true;
                        ans++;
                    }
                }
            }
        }


        System.out.println(ans);

    }
}
