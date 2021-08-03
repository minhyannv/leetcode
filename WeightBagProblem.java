package algorithms;
/**
 * @author wmy
 * @date 2021/7/25 18:52
 */

import javax.swing.*;

/**
 * 背包问题
 */
public class WeightBagProblem {

//    /**
//     * 动态规划
//     * dp[i][j]:从下标0~i中选取物品放在重量为j的背包中的最大收益
//     * dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
//     * 背包容量为j，⾥⾯不放物品i的最⼤价值，此时dp[i][j]=dp[i - 1][j]
//     * 背包容量为j - weight[i]，不放物品i的最⼤价值，那么dp[i][j]=dp[i - 1][j - weight[i]] + value[i] （物品i的价值），
//     *
//     * @param weight
//     * @param value
//     * @param bagWeight
//     * @return
//     */
//    public int weightBag(int[] weight, int[] value, int bagWeight) {
//        int[][] dp = new int[weight.length][bagWeight + 1];
//        //初始化dp[i][0]为0（默认为0）
//        //初始化dp[0][0~weight[0]]为0，dp[0][weight[0]~bagWeight]为value[0]
//        for (int j = weight[0]; j <= bagWeight; j++) {
//            dp[0][j] = value[0];
//        }
//        for (int i = 1; i < weight.length; i++) {
//            for (int j = 0; j <= bagWeight; j++) {
//                if (j < weight[i]) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
//                }
//            }
//        }
//        return dp[weight.length - 1][bagWeight];
//    }

    /**
     * 动态规划
     * dp[j]:从下标0~i中选取物品放在重量为j的背包中的最大收益
     * dp[j] = max(dp[j],dp[j-weight[i]+value[i])
     *
     * @param weight
     * @param value
     * @param bagWeight
     * @return
     */
    public int weightBag(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        //初始化dp[j]为0（默认为0）
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        WeightBagProblem app = new WeightBagProblem();
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int res = app.weightBag(weight, value, bagWeight);
        System.out.println(res);

    }
}
