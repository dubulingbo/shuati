package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-10-30 15:04
 * i believe i can i do
 */
public class T10_05 {
    // 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
    public int findString(String[] words, String s) {
        // 二分法
        int left = 0;
        int right = words.length - 1;
        int tmp;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 暂存mid的值
            tmp = mid;

            // 去除 mid 附近的 空字符串
            while (mid >= left && words[mid].equals("")) mid--;

            // 左边部分都是空字符串，调整left的值，直接进行下一趟循环
            if (mid == left - 1) {
                left = tmp + 1;
                continue;
            }


            // 左边部分：words[left,mid]   右边部分：[tmp + 1, right]
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                // 这里就不是 mid + 1，可以省略一些空字符串的查找
                left = tmp + 1;
            }
        }
        return -1;
    }
}
