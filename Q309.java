package algorithms;

/**
 * 题目描述:
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Q309 {

    public int maxProfit(int[] prices) {
        /**
         * 动态规划
         *
         * hold[i] 第i天持有股票，最大收益
         * unhold[i] 第i天不持有股票，最大收益
         *
         * 1.第i天手中持有股票
         *      a. i-1天持有股票，i天休息
         *      b. i-2天卖了股票，i-1天处于冷冻期，i天购入
         *      状态转移方程:   hold[i] = max(hold[i-1],unhold[i-2]-prices[i])
         * 2.第i天手中未持有股票
         *      a. i-1天卖出，i天处于冷冻期
         *      b. i-1天之前卖出，i天休息
         *      b. i-1天持有股票，i天卖出
         *      状态转移方程:   unhold[i] = max(hold[i-1]+prices[i],unhold[i-1])
         */
        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) { //第0天
                hold[i] = -prices[i]; //持有股票，说明第0天就购入
                unhold[i] = 0;//未持有股票，第0天没购入
            } else if (i == 1) { //第1天
                hold[i] = Math.max(-prices[0], -prices[i]); //持有股票，第0天购入，第1天没卖或者第1天购入
                unhold[i] = Math.max(hold[i - 1] + prices[i], unhold[i - 1]);
            } else {
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
                unhold[i] = Math.max(hold[i - 1] + prices[i], unhold[i - 1]);
            }
        }
        return unhold[prices.length - 1];

    }


    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        Q309 q = new Q309();
        int ans = q.maxProfit(prices);
        System.out.println(ans);

    }
}
