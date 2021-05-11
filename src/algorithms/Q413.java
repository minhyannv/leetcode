package algorithms;

/**
 * 题目描述:
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，以下数列为等差数列:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * <p>
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * <p>
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * <p>
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且P + 1 < Q 。
 * <p>
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */


public class Q413 {
//    public int numberOfArithmeticSlices(int[] nums) {
//        /**
//         * 暴力枚举
//         * 针对任意两个长度大于等于3的区间，判断其是否是等差数列，如果是则加1
//         */
//        int ans = 0;
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 2; j < len; j++) {
////                System.out.println("i : " + i + " j: " + j);
//                int d = nums[j] - nums[j - 1];
//                boolean flag = true;
//                for (int k = i; k < j; k++) {
//                    if (nums[k + 1] - nums[k] != d) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    ans += 1;
//                }
//            }
//        }
//        return ans;
//    }

    public int numberOfArithmeticSlices(int[] nums) {
        /**
         *
         * 动态规划
         * 状态 dp[i]:必包含索引i对应值的等差数列个数
         * 状态转移方程
         *      如果 nums[i]-nums[i-1] == nums[i-1]-nums[i-2] dp[i] = dp[i-1]+1
         *      否则 dp[i] = 0
         */
        int ans = 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == 1) { //边界条件
                dp[i] = 0;
                continue;
            }
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                ans += dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q413 q = new Q413();
        int ans = q.numberOfArithmeticSlices(nums);
        System.out.println(ans);
    }
}
