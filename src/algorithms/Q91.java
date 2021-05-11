package algorithms;

import java.util.Arrays;

/**
 * 题目描述:
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 */


public class Q91 {

    public int numDecodings(String s) {
        /**
         * 动态规划
         * 状态dp[i] 解码总数
         * 状态转移方程
         * 使用 s[i]进行解码
         *      dp[i] = dp[i-1]
         * 使用 s[i-1]和s[i]进行解码
         *      dp[i] += dp[i-2]
         *
         */

        int len = s.length();
        int[] intArr = new int[len];
        for (int i = 0; i < s.length(); i++) {
            intArr[i] = s.charAt(i) - '0';
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (intArr[i] == 0) {
                    return 0;
                } else {
                    dp[i] = 1;
                }
                continue;
            }
            if (i == 1) {
                if (intArr[i] > 0) {
                    dp[i] = 1;
                }
                if (intArr[i - 1] * 10 + intArr[i] <= 26) {
                    dp[i] += 1;
                }
                continue;
            }
            if (intArr[i] == 0 && intArr[i - 1] == 0) {  //若连续出现2个0,则无法解码，返回0
                return 0;
            }
            if (intArr[i] != 0) { //考虑一个数字解码
                dp[i] = dp[i - 1];
            }
            if (intArr[i - 1] != 0 && intArr[i - 1] * 10 + intArr[i] <= 26) { //考虑两个数字解码
                dp[i] += dp[i - 2];
            }

        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        String s = "207";
        Q91 q = new Q91();
        int ans = q.numDecodings(s);
        System.out.println(ans);

    }
}
