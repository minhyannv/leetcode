package algorithms;

/**
 * 题目描述:
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 */

public class Q75 {
//    /**
//     * 先将2移动到最后，再将1移动到中间
//     *
//     * @param nums
//     */
//    public void sortColors(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            while (nums[left] != 2 && left < right) {
//                left++;
//            }
//
//            while (nums[right] == 2 && left < right) {
//                right--;
//            }
//
//            //交换值
//            int temp = nums[left] + nums[right];
//            nums[left] = temp - nums[left];
//            nums[right] = temp - nums[left];
//        }
//        left = 0;
//        if (nums[right] == 2) {
//            right--;
//        }
//
//        while (left < right) {
//            while (nums[left] != 1 && left < right) {
//                left++;
//            }
//
//            while (nums[right] == 1 && left < right) {
//                right--;
//            }
//            //交换值
//            int temp = nums[left] + nums[right];
//            nums[left] = temp - nums[left];
//            nums[right] = temp - nums[left];
//        }
//    }

    /**
     * 双指针方法
     * 如果nums[i]==2
     *  交换nums[i]与nums[right],不断往左移动right,直到nums[i]!=2
     * 如果nums[i]==0
     *  交换nums[i]与nums[left],left++
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        for (int i = 0; i <= right; i++) {
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {1, 0};
        Q75 q = new Q75();
        q.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}



