package algorithms;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 */

public class Q213 {
    public int rob(int[] nums) {
        /**
         * 如果房间数<=2，则只能偷一间房
         * 如果房间数大于2，则可选择偷第一间房或者偷最后一间房
         *      偷第一间房 则可偷范围为[0~n-2] ,求最大值
         *      偷最后一间房，则可偷范围为[1~n-1]，求最大值
         * 选取两个最大值中的最大值最为结果返回
         */
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    /**
     * rob 方法重写
     *
     * 动态规划
     * 状态转移方程
     * dp[i] 代表抢到第i个住户的最大收益
     * 分两种情况，如果抢第i个用户，则第i-1个用户不能抢，则最大收益为dp[i-2]+nums[i]
     * 如果不抢i用户，则最大收益和dp[i-1]一致
     * dp[i] = max(dp[i-2]+nums[i],dp[i-1])
     *
     * @param nums  房屋金钱数组
     * @param start 偷盗房屋开始位置
     * @param end   偷盗房屋结束位置
     * @return 最大利益
     */
    public int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        for (int i = start; i <= end; i++) {
            if (i == start) {
                dp[i] = nums[i];
            } else if (i == start + 1) {
                dp[i] = Math.max(nums[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[end];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Q213 q = new Q213();
        int ans = q.rob(nums);
        System.out.println(ans);

    }
}
