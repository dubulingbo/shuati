package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-11-02 15:25
 * i believe i can i do
 */
public class T16_11 {
    // 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
    // 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
    // 返回的长度需要从小到大排列。
    // 链接：https://leetcode-cn.com/problems/diving-board-lcci
    public int[] divingBoard(int shorter, int longer, int k) {
        // 思路：刚好是首项为 k 个 shorter，公差为【longer - shorter】，尾项是 k 个 longer 的等差数列的 每一项
        if (k <= 0) return new int[0];
        if (shorter == longer) return new int[]{k * shorter};
//        List<Integer> ans = new ArrayList<>();
//
//        for (int x = k * shorter; x <= k * longer; x += (longer - shorter)) {
//            ans.add(x);
//        }
//        return ans.stream().mapToInt(Integer::valueOf).toArray();

        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ans[i] = k * shorter + i * (longer - shorter);
        }
        return ans;
    }
}
