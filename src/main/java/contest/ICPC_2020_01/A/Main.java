package contest.ICPC_2020_01.A;

import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-10-25 15:46
 * i believe i can i do
 */
public class Main {
    // 辗转相除法，求最小公倍数
    public static int leastCommon(int a, int b) {
        int a1 = a;
        int b1 = b;
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return a1 * b1 / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cite = new int[n];
        for (int i = 0; i < n; i++) {
            cite[i] = sc.nextInt();
        }

        int k = 1;
        int dp[] = new int[n];

        for(int i=0;i<n;i++){
            if(cite[i] == k){
                k++;
                dp[i] = dp[i] + 1;
            }else{
                dp[i] = dp[i-1];
            }
        }
    }
}
