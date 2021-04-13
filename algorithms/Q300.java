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
        int ans = 1;
        int[] len = new int[nums.length]; //存储从初始位置到当前位置的最长序列
        for (int i = 0; i < len.length; i++) { //最长序列初始化为1
            len[i] = 1;
        }
        /**
         * 动态规划，从前往后找最长升序
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                    if (len[i] > ans) { //找的同时记录最大值
                        ans = len[i];
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {7, 7, 7};

        Q300 q = new Q300();
        int ans = q.lengthOfLIS(nums);
        System.out.println(ans);
    }
}


