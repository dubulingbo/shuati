package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 21:29
 * i believe i can i do
 */
public class T121 {
    // 121. 买卖股票的最佳时机
    // 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    // 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    public int maxProfit(int[] prices) {
        // 动态规划 | 贪心
        if (prices.length < 2) return 0;
        // 记录买入的最低价
        int preMin = prices[0];
        // 最大收益
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            // 第 i 天卖出的最大收益
            max = Math.max(max, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new T121().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
