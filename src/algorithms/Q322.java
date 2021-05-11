import java.util.Arrays;

/**
 * 题目描述
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 */

public class Q322 {
    public int coinChange(int[] coins, int amount) {
        /**
         * 动态规划
         * 状态转移方程：dp[i] = min{dp[i-c_1],dp[i-c_2],..}+1,其中i代表金额i,dp[i]代表组成金额i最少的硬币数
         */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                    System.out.println("dp[" + i + " - " + coin + "]" + "=" + "dp[" + (i - coin) + "]" + "=" + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        Q322 q = new Q322();
        int ans = q.coinChange(nums, amount);
        System.out.println(ans);
    }
}


