package algorithms;

import java.util.Arrays;

/**
 * 题目描述:
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */


public class Q279 {
    /**
     * 动态规划
     * dp[i] 代表和为i的平方数的最少数量
     * dp[i] = Math.min(dp[i-y_j[k]]+1,dp[i]),其中y[j]代表平方数数组,j=1,2,3...,k
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int x = (int) Math.sqrt(n) + 1;
        int[] y = new int[x]; //平方数数组
        for (int i = 1; i < x; i++) {
            y[i - 1] = i * i;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int i1 : y) {
                if (i - i1 >= 0) {
                    dp[i] = Math.min(dp[i - i1] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 12;
        Q279 q = new Q279();
        int ans = q.numSquares(n);
        System.out.println(ans);

    }
}
