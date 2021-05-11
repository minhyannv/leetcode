package algorithms;

/**
 * 题目描述:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */


public class Q169 {

    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int val = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                val++;
            } else {
                val--;
                if (val == 0) {
                    ans = nums[i];
                    val++;
                }
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Q169 q = new Q169();
        int ans = q.majorityElement(nums);
        System.out.println(ans);
    }
}
