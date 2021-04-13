package algorithms; /**
 * 题目描述:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Q215 q = new Q215();
        int ans = q.findKthLargest(nums, k);
        System.out.println(ans);
    }
}



