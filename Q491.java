package algorithms;

import java.util.*;

/**
 * 题目描述
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * ?
 * <p>
 * 提示：
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是?[-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q491 {


    /**
     * 递归方法
     */
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        backTracking(nums, len, 0);
        return res;
    }

    private void backTracking(int[] nums, int len, int startIndex) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path)); //收集所有满足条件的子集
        }
        if (startIndex == len) { //递归停止
            return;
        }
        Set<Integer> used = new HashSet<>(); //同一父节点已使用的节点
        for (int i = startIndex; i < len; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) { //剪枝
                continue;
            }
            if (used.contains(nums[i])) { //同一父节点的子节点不能重复使用
                continue;
            } else {
                used.add(nums[i]);
            }
            path.addLast(nums[i]);
            backTracking(nums, len, i + 1); //递归
            path.removeLast();//回溯
        }
    }


    public static void main(String[] args) {
        int[] nums = {4, 7, 6, 7};
        Q491 q = new Q491();
        List<List<Integer>> ans = q.findSubsequences(nums);
        System.out.println(ans);
    }
}


