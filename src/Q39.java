/**
 * 题目描述:
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 */

import java.util.*;

public class Q39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        Stack<Integer> path = new Stack<>(); // 树路径
        boolean[] used = new boolean[len]; //是否访问
        dfs(candidates, ans, 0, len, used, path, target);
        return ans;
    }

    private int sum(List<Integer> res) {
        int s = 0;
        for (Integer re : res) {
            s += re;
        }
        return s;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, int depth, int len, boolean[] used, Stack<Integer> path, int target) {
        if (sum(new ArrayList<>(path)) == target) { //树深最大
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) { // 如果当前数已尽被访问
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, ans, depth + 1, len, used, path, target);
            path.pop();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Q39 q = new Q39();
        List<List<Integer>> ans = q.combinationSum(candidates, target);
        System.out.println(ans);
    }
}


