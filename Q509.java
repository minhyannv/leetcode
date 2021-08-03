package algorithms;
/**
 * 题目描述:
 * 斐波那契数，通常⽤ F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后⾯的每⼀项
 * 数字都是前⾯两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你n ，请计算 F(n) 。
 * 示例 1：
 * 输⼊：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输⼊：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * 输⼊：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 提示：
 * 0 <= n <= 30
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q509 {

    /**
     * 递归
     * dp[i]:下标i的斐波那契数
     * 状态转移公式：dp[i] = dp[i-1]+dp[i-2]
     * 边界条件：dp[0]=0,dp[1] = 1
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
//    /**
//     * 动态规划1:维护所有的状态值
//     * dp[i]:下标i的斐波那契数
//     * 状态转移公式：dp[i] = dp[i-1]+dp[i-2]
//     * 边界条件：dp[0]=0,dp[1] = 1
//     *
//     * @param n
//     * @return
//     */
//    public int fib(int n) {
//        int[] dp = new int[n + 1];
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
//
//    /**
//     * 动态规划2:维护两个值
//     * dp[i]:下标i的斐波那契数
//     * 状态转移公式：dp[i] = dp[i-1]+dp[i-2]
//     * 边界条件：dp[0]=0,dp[1] = 1
//     *
//     * @param n
//     * @return
//     */
//    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        int[] dp = new int[2];
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[1] = dp[1] + dp[0];
//            dp[0] = dp[1] - dp[0];
//        }
//        return dp[1];
//    }

    public static void main(String[] args) {
        int n = 3;
        Q509 q = new Q509();
        int ans = q.fib(n);
        System.out.println(ans);
    }
}


