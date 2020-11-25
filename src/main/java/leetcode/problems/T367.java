package leetcode.problems;

public class T367 {
    // 367. 有效的完全平方数
    // 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
    public boolean isPerfectSquare(int num) {
        // 二分法
        if(num == 1) return true;
        long left = 2, right = num / 2;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid == num) return true;
            else if(mid * mid > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T367().isPerfectSquare(1));
        System.out.println(new T367().isPerfectSquare(16));
        System.out.println(new T367().isPerfectSquare(14));
    }
}
