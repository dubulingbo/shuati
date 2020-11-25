package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author DubLBo
 * @since 2020-11-10 20:29
 * i believe i can i do
 */
public class T118 {
    // 118. 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            List<Integer> preRow = res.get(i - 1);

            curRow.add(1);
            for (int j = 1; j < i; j++) {
                curRow.add(preRow.get(j - 1) + preRow.get(j));
            }
            curRow.add(1);

            res.add(curRow);
        }

        return res;
    }

    // 119. 杨辉三角 II
    public List<Integer> getRow(int rowIndex) {
        List<Integer> triangle = new ArrayList<>();
        triangle.add(1);
        if (rowIndex == 0) return triangle;
        int pre = 0;
        int[][] t = new int[2][rowIndex + 1];
        t[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            t[1 - pre][0] = 1;

            for (int j = 1; j < i; j++) {
                t[1 - pre][j] = t[pre][j] + t[pre][j - 1];
            }
            t[1 - pre][i] = 1;
            pre = 1 - pre;
        }

        for (int i = 1; i <= rowIndex; i++) {
            triangle.add(t[pre][i]);
        }
        return triangle;
    }

    public static void main(String[] args) {
        int n = new Random().nextInt(20);
        for(int i =0;i<n;i++){
            System.out.println(new T118().getRow(i));
        }

//        System.out.println(new T118().getRow(1));
//        System.out.println(new T118().getRow(2));
//        System.out.println(new T118().getRow(3));
//        System.out.println(new T118().getRow(4));
//        System.out.println(new T118().getRow(5));
//        System.out.println(new T118().getRow(6));
//        System.out.println(new T118().getRow(7));
//        System.out.println(new T118().getRow(8));
//        System.out.println(new T118().getRow(9));
//        System.out.println(new T118().getRow(10));
    }
}
