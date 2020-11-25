package nowcoder.contest.th29.A;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-11-14 21:20
 * i believe i can i do
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[][] house = new int[m][2];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < m; i++) house[i][0] = sc.nextInt();

        for (int i = 0; i < m; i++) house[i][1] = sc.nextInt();

        Arrays.sort(house, (o1, o2) -> o2[1] - o1[1]);

        int maxValue = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxValue = 0;
            for (int j = 0; j < m; j++) {
                if(a[i] > house[j][0]){
                    maxValue = house[j][1];
                    break;
                }
            }
            maxSum += maxValue;
        }

        System.out.println(maxSum);
    }
}
