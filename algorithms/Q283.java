/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

public class Q283 {

    public void moveZeroes(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return;
        }
        int i = nums.length - 1, j = nums.length - 1;
        while (i >= 0) {
            while (i >= 0 && nums[i] != 0) { // 从后寻找第一个0
                i--;
            }
            if (i < 0) {
                break;
            }
            for (int k = i; k < j; k++) { // 索引i到j前移一位
                nums[k] = nums[k + 1];
            }
            nums[j] = 0;
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        Q283 q = new Q283();
        q.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");

        }
    }
}


