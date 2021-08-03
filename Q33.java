/**
 * 题目描述:
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回-1。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 */

import java.util.ArrayList;
import java.util.List;

public class Q33 {


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) { // nums[mid]在左半段
                if (target >= nums[left] && target < nums[mid]) { // target在nums[mid]左边
                    right = mid - 1;
                } else {// target在nums[mid]右边
                    left = mid + 1;
                }
            } else {  // nums[mid]在左半段
                if (target <= nums[right] && target > nums[mid]) { // target在nums[mid]左边
                    left = mid + 1;
                } else {// target在nums[mid]右边
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 1};

        int target = 1;
        Q33 q = new Q33();
        int ans = q.search(nums, target);
        System.out.println(ans);
    }
}


