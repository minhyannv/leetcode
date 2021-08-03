package algorithms;

import java.util.Arrays;

/**
 * 给定一个已按照 升序排列' 的整数数组'numbers ，请你从数组中找出两个数满足相加之和等于目标数'target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * '
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 */


public class Q167 {

    public int[] twoSum(int[] numbers, int target) {
        /**
         * 双指针题目
         */
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        Q167 q = new Q167();
        int[] ans = q.twoSum(numbers, target);
        System.out.println(Arrays.toString(ans));
    }
}
