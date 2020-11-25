package contest.ICPC_2020_02.H;

import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-10-31 12:32
 * i believe i can i do
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] packet = new int[n][2];
            for(int i=0;i<n;i++){
                packet[i][0] = sc.nextInt();
                packet[i][1] = sc.nextInt();
            }

            // dp[i][j] 表示 前packet[0....j] 塞进容量为 i 的背包里的最大价值
            int[][] dp = new int[m+1][n];

            for(int i = 1;i<=m;i++){
                // 装第一个的最大值
                if(m >= packet[0][0]){
                    dp[i][0] = packet[0][1];
                }
            }


            for(int i=1;i<=m;i++){
                for(int j=1;j<n;j++){
                    // 不装 第 j个包
                    dp[i][j] = dp[i][j-1];
                    // 第 j 个包能装下，就继续装
                    if(packet[j][0] <= i){ // 能不能放下
                        dp[i][j] = Math.max(dp[i - packet[j][0]][j-1] + packet[j][1] , dp[i][j]);
                    }
                }
            }

            System.out.println(dp[m][n-1]);
//            return dp[m][n-1];
        }
    }
}
