import java.util.LinkedList;

/**
 * 题目描述
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 */

public class Q239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) { //队列为空
                queue.addLast(nums[i]);
            } else {
                while (queue.size() >= k) { //队列长度超出窗口大小
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && queue.peekLast() < nums[i]) { //维护降序队列
                    queue.removeLast();
                }
                queue.addLast(nums[i]);
            }
            if (i >= k - 1) {

                res[++idx] = queue.peekFirst();

            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        // int[] nums = {1, -1};
        int[] nums = {1, 3, 1, 2, 0, 5};

        int k = 3;
        Q239 q = new Q239();
        int[] ans = q.maxSlidingWindow(nums, k);
        for (int an : ans) {
            System.out.println(an);
        }
    }
}


