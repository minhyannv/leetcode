package algorithms;

/**
 * 题目描述:
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：1
 */


public class Q287 {

    public int findDuplicate(int[] nums) {

        int[] flag = new int[nums.length];
        for (int num : nums) {
            flag[num] += 1;
        }
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] > 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        Q287 q = new Q287();
        int ans = q.findDuplicate(nums);
        System.out.println(ans);
    }
}
