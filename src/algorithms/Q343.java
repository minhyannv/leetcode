package algorithms;

/**
 * 题目描述:
 * 给定一个正整数n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
 */
public class Q343 {

    public int integerBreak(int n) {
        /**
         * 动态规划
         * dp[i]:将i拆分成两个数之后得到的最大乘积
         *  dp[i] = max(j*(i-j), j*dp[i-j])
         *
         */
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                dp[i] = 0;
                continue;
            }
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 10;
        Q343 q = new Q343();
        int ans = q.integerBreak(n);
//        System.out.println(ans);
    }
}
