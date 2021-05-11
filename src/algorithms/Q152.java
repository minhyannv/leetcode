package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

public class Q152 {


    public int maxProduct(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int idxMax = 1;
        int idxMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = idxMax;
                idxMax = idxMin;
                idxMin = tmp;
            }
            idxMax = Math.max(idxMax * num, num);
            idxMin = Math.min(idxMin * num, num);
            max = Math.max(max, idxMax);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        Q152 q = new Q152();
        int ans = q.maxProduct(nums);
        System.out.println(ans);
    }
}


