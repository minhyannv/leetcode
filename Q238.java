package algorithms;

import java.util.Arrays;

/**
 * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */

public class Q238 {

    public int[] productExceptSelf(int[] nums) {
        /**
         * left[i]存储i到i-1的累计乘积
         * right[i]存储i+1到末尾的累计乘积
         */
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        Arrays.fill(left, 1);
        int[] right = new int[nums.length];
        Arrays.fill(right, 1);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
            } else if (i == 1) {
                left[i] = nums[i - 1];
            } else {
                left[i] = left[i - 1] * nums[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right[i] = 1;
            } else if (i == nums.length - 2) {
                right[i] = nums[nums.length - 2 + 1];
            } else {
                right[i] = right[i + 1] * nums[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q238 q = new Q238();
        int[] ans = q.productExceptSelf(nums);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}


