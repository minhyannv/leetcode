package algorithms;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号+和-。对于数组中的任意一个整数，你都可以从+或-中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 */

public class Q494 {

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, target, nums.length);

    }

    private int dfs(int i, int[] nums, int target, int len) {
        if (i == len && target == 0) {
            return 1;
        }
        if (i >= len) {
            return 0;
        }
        int ans = 0;
        ans += dfs(i + 1, nums, target - nums[i], len);
        ans += dfs(i + 1, nums, target + nums[i], len);
        return ans;

    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Q494 q = new Q494();
        int median = q.findTargetSumWays(nums, target);
        System.out.println(median);
    }
}


