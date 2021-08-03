package algorithms;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值?cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * ?
 * <p>
 * 示例?1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * ?示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * ?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q746 {
    /**
     * 动态规划
     * dp[i]: 爬到第i阶台阶所需要的最小花费
     * 状态转移方程：
     * dp[i] = min(dp[i-1],dp[i-2])+cost[i]
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return cost[0];
        }

        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int temp = Math.min(dp[0], dp[1]) + cost[i];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        // 可以从倒数第二个越过顶楼，那么顶楼不花费，也可以最后到达顶楼，
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        Q746 q = new Q746();
        int ans = q.minCostClimbingStairs(cost);
        System.out.println(ans);
    }
}


