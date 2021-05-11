package algorithms;

import java.util.Arrays;

/**
 * 给你两个有序整数数组'nums1 和 nums2，请你将 nums2 合并到'nums1'中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化'nums1 和 nums2 的元素数量分别为'm 和 n 。你可以假设'nums1 的空间大小等于'm + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 双指针逆向归并
         * 每次从num1的有效数字中和nums2中选出一个最大值放到nums最后
         */
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int tailPointer = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (tailPointer >= 0) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[tailPointer] = nums1[m];
                    m--;
                } else if (nums1[m] < nums2[n]) {
                    nums1[tailPointer] = nums2[n];
                    n--;
                }
            } else if (m >= 0) {//m>=0 && n<0
                return;
            } else { //m<0 && n>=0
                nums1[tailPointer] = nums2[n];
                n--;
            }
            tailPointer--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        Q88 q = new Q88();
        q.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}


