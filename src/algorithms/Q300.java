package algorithms;

/**
 * 题目描述
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        /**
         * 动态规划
         * 状态 dp[i] : 位置0-i对应的最长子序列长度
         */
        int maxLen = 1;
        int arrLen = nums.length;
        int[] dp = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            int max = 1;//计算从0-i最长的子序列长度max
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {7, 7, 7};

        Q300 q = new Q300();
        int ans = q.lengthOfLIS(nums);
        System.out.println(ans);
    }
}


