package algorithms;

import java.util.Arrays;

/**
 * 题目描述
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)是正负交替出现的。相反, [1,4,7,2,5]和[1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 * <p>
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 * <p>
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * 进阶:
 * 你能否用O(n) 时间复杂度完成此题?
 */

public class Q376 {
    public int wiggleMaxLength(int[] nums) {
        /**
         * 动态规划
         * dp[i] 位置0-i最长摆动序列
         *
         */
        int arrLen = nums.length;
        int maxLen = 0;
        int[] flag = new int[arrLen]; //位置i最长摆动序列对应的符号位
        Arrays.fill(flag, 1);
        int[] dp = new int[arrLen]; //位置0-i最长摆动序列长度
        for (int i = 0; i < arrLen; i++) {
            if (i == 0) { //边界条件：只有一个数
                dp[i] = 1;
                maxLen = dp[i];
                continue;
            }
            if (i == 1) { //边界条件：只有两个数
                flag[i] = nums[i] - nums[i - 1];
                if (flag[i] != 0) {
                    dp[i] = 2;
                } else {
                    dp[i] = 1;
                }
                maxLen = Math.max(dp[i - 1], dp[i]);
                continue;
            }
            int max = 1;
            for (int j = 0; j < i; j++) {
                flag[i] = nums[i] - nums[j];
                if (flag[i] * flag[j] < 0) {//说明异号
                    if (dp[j] + 1 > max) {
                        max = dp[j] + 1;
                    }
                }
            }
            dp[i] = max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        for (int i : dp) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i : flag) {
            System.out.print(i + "  ");
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 7, 4, 9, 2, 5};
        Q376 q = new Q376();
        int ans = q.wiggleMaxLength(nums);
//        System.out.println(ans);
    }
}


