package nowcoder.contest.th29.E;

import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-11-14 21:41
 * i believe i can i do
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] my = new int[n];
        int[] friend = new int[n];

        for (int i = 0; i < n; i++) my[i] = sc.nextInt();
        for (int i = 0; i < n; i++) friend[i] = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int same = 0;
        for (int i = 0; i < n; i++) {
            if (my[i] == friend[i]) same++;
        }

        int res = 0;
        if (k >= n - same) {
            res = n - same + n - k;
        } else {
            res = n - (n - same - k);
        }
        System.out.println(res);
    }
}
