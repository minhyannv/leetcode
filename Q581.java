package algorithms;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 */

public class Q581 {

    /**
     * 暴力法
     */
//    public int findUnsortedSubarray(int[] nums) {
//        /**
//         * 从左往右找第一个无序开头的数
//         * 从右往左找第一个无序开头的数
//         */
//        int left = -1, right = -1;
//        for (int i = 0; i < nums.length; i++) {
//            boolean flag = false;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                left = i;
//                break;
//            }
//        }
//        for (int i = nums.length - 1; i >= 0; i--) {
//            boolean flag = false;
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[i] < nums[j]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                right = i;
//                break;
//            }
//        }
//        System.out.println(left + " " + right);
//        if (left == right) {
//            return 0;
//        } else {
//            return right - left + 1;
//        }
//    }
    public int findUnsortedSubarray(int[] nums) {
        /**
         * 从左往右遍历nums,记录最大值，如果nums[i]小于最大值，那么当前位置不是正确位置，需要记录位置，重排，否则更新最大值
         * 从右往左遍历，记录最小值，如nums[i]大于最小值，那么当前位置不是正确位置，需要记录位置，重排，否则更新最小值
         */
        int numsLen = nums.length;
        int minVal = nums[numsLen - 1];
        int maxVal = nums[0];
        int left = 0;
        int right = -1;
        for (int i = 0; i < numsLen; i++) {
            if (nums[i] < maxVal) {
                right = i;
            } else {
                maxVal = nums[i];
            }
            if (nums[numsLen - i - 1] > minVal) {
                left = numsLen - i - 1;
            } else {
                minVal = nums[numsLen - i - 1];
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums = {1, 2, 3, 4};

        Q581 q = new Q581();
        int ans = q.findUnsortedSubarray(nums);
        System.out.println(ans);
    }
}


