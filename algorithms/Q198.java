package algorithms;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

public class Q198 {
    public int rob(int[] nums) {
        /**
         * 动态规划
         * 状态转移方程
         * i:房间号，f(i)：偷到第i房得到的收益，g(i):不偷第i房得到的收益
         * f[i] = g[i-1]+nums[i]
         * g[i] = max(f[i-1],g[i-1]}
         */
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                f[i] = nums[i];
                res = Math.max(f[i], res);
                g[i] = 0;

            } else {
                f[i] = g[i - 1] + nums[i];
                res = Math.max(f[i], res);
                g[i] = Math.max(f[i - 1], g[i - 1]);
                res = Math.max(g[i], res);

            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Q198 q = new Q198();
        int ans = q.rob(nums);
        System.out.println(ans);

    }
}
