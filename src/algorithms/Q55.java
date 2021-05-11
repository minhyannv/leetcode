package algorithms;

/**
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */

public class Q55 {


    public boolean canJump(int[] nums) {
        /**
         * 贪心方法
         */
        if (nums.length == 1) {
            return true;
        }
        int can = 0; //能跳到的最远距离
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > can) { //i 大于所能跳到的最远位置
                return false;
            }
            if (i + nums[i] > can) {
                can = i + nums[i];
            }

        }
        //能否跳到最后
        return can >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 2, 1, 2, 2, 2};
        Q55 q = new Q55();
        boolean ans = q.canJump(nums);
        System.out.println(ans);
    }
}


