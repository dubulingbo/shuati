package leetcode.icof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-18 16:17
 * i believe i can i do
 */
public class T062 {
    // 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
    // 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
    // 循环出圈问题：循环报数出局：约瑟夫环问题

    public int lastRemaining(int n, int m) {
        // 逆推法
        int ans = 0;

        for (int i = 2; i < n + 1; i++) {
            ans = (ans + m) % i;
        }

        return ans;
    }


    public int lastRemaining_zhijie(int n, int m) {
        // 对出局的次数进行循环：超时

//        if (n <= 0 || m <= 0) {
//            // 无法进行游戏
//            return -1;
//        }
//        // 存储 0~n-1 这n个数字
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = i;
//        }
//        // 记录本轮开始的数的下标
//        int cur = 0;
//
//        while (n > 1) { // 当前还剩下的数的数量
//            // 第 m 个数出局的 下标
//            cur = (cur + m - 1) % n;
//
//            // 覆盖掉 arr[index]：模拟出局
//            for (int i = cur; i < n - 1; i++) {
//                arr[i] = arr[i + 1];
//            }
//
//            n--;
//        }
//        return arr[0];

        // 对出局的次数进行循环：超时
        // 使用List优化

        if (n <= 0 || m <= 0) {
            // 无法进行游戏
            return -1;
        }

        // 存储 0~n-1 这n个数字
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 记录本轮开始的数的下标
        int cur = 0;

        while (n > 1) { // 当前还剩下的数的数量
            // 第 m 个数出局的 下标
            cur = (cur + m - 1) % n;

            // 覆盖掉 arr[index]：模拟出局
            list.remove(cur);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new T062().lastRemaining(10, 17));
        System.out.println(new T062().lastRemaining(5, 3));
    }
}
