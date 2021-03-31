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
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0) {
            return ans;
        }
        if (candidates.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[0]);
            ans.add(list);
            return ans;
        }
        int sum = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        dfs(i, stack, sum, target, ans, candidates);

        return ans;
    }

    private void dfs(int i, Stack<Integer> stack, int sum, int target, List<List<Integer>> ans, int[] candidates) {
        if (sum >= target) { //结束递归
            if (sum == target) {
                ans.add(new ArrayList<>(stack));
            }
            return;
        }
        for (int j = i; j < candidates.length; j++) { // 枚举当前可选的数，从start开始
            stack.push(candidates[j]);          // 选这个数
            dfs(j, stack, sum + candidates[i], target, ans, candidates); // 基于此，继续选择，传i，下次就不会选到i左边的数
            stack.pop();   // 撤销选择，回到选择candidates[i]之前的状态，继续尝试选同层右边的数
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


