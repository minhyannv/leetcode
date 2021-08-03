package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述:
 * 给定一个整数数组和一个整数'k，你需要找到该数组中和为'k'的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * <p>
 */


public class Q560 {
    /**
     * 暴力
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans += 1;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        int k = 0;
        Q560 q = new Q560();
        int ans = q.subarraySum(nums, k);
        System.out.println(ans);
    }
}
