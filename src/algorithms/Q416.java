package algorithms;

/**
 * 题目描述:
 * 给你一个 只包含正整数 的 非空 数组'nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */


public class Q416 {
    public boolean canPartition(int[] nums) {
        /**
         * dp[i][j] =在下标0-i区间是否可以选出一些数，使得其和为j,如果是则为true,否则为false
         * 状态转移方程
         *      dp[i][j] = dp[i-1][j]  在0-(i-1)区间可以选出一些数，使得其和为j,则0-i包含0-(i-1),也为true
         *      如果dp[i][j]为false
         *          如果nums[i]=j，则直接为true
         *          否则，需要满足在0-(i-1)选出一些数字，使得其和为j-nums[i]，否为false
         *
         */
        int len = nums.length;
        if (len <= 1) {
            return false;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }

        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        if (max > sum) {
            return false;
        }

        boolean[][] dp = new boolean[len][sum + 1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                }
                if (nums[i] < j && !dp[i][j]) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }
//        for (boolean[] booleans : dp) {
//            for (boolean aBoolean : booleans) {
//                System.out.print(aBoolean + " ");
//            }
//            System.out.println();
//        }
        return dp[len - 1][sum];
    }


    public static void main(String[] args) {
        int[] nums = {9, 5};
        Q416 q = new Q416();
        boolean ans = q.canPartition(nums);
        System.out.println(ans);
    }
}
