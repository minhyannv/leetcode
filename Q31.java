package algorithms; /**
 * 题目描述:
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路：
 * a.从后往前找到第一个升序对num[l],nums[r](从r到结尾都是降序)
 * b.从r到结尾找到第一个比nums[l]大的数nums[k],交换nums[l]与nums[k]的值(从r到结尾都是降序)
 * c.从r到结尾进行升序
 */
public class Q31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int l = nums.length - 2, r = nums.length - 1;
        while (nums[l] >= nums[r] && l > 0) {  // 从后往前寻找第一个升序对
            l--;
            r--;
        }
        if (l == 0 && nums[l] >= nums[r]) { //说明数组降序排列，需要倒序输出得到最小排列{
            for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
                int temp = nums[i] + nums[j];
                nums[i] = temp - nums[i];
                nums[j] = temp - nums[i];
            }

        } else {
            //从后往前找比nums[l]大的第一个遇到的的数
            int k = nums.length - 1;
            while (nums[k] <= nums[l]) {
                k--;
            }
            // 交换 num[l]与nums[k]
            int temp = nums[l] + nums[k];
            nums[l] = temp - nums[l];
            nums[k] = temp - nums[k];
            // 从r 到 最后升序排序
            for (int i = r, j = nums.length - 1; i < j; i++, j--) {
                int temp1 = nums[i] + nums[j];
                nums[i] = temp1 - nums[i];
                nums[j] = temp1 - nums[i];
            }

        }
    }
}
