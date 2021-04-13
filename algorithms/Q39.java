package algorithms; /**
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
        Arrays.sort(candidates); //候选集排序
        List<Integer> use = new ArrayList<>();
        dfs(0, candidates, ans, use, target);
        return ans;
    }

    private void dfs(int idx, int[] candidates, List<List<Integer>> ans, List<Integer> use, int remain) {
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] == remain) {
                List<Integer> temp = new ArrayList<>(use);
                temp.add(candidates[i]);
                ans.add(temp);
            }
            if (candidates[i] < remain) {
                List<Integer> temp = new ArrayList<>(use);
                temp.add(candidates[i]);
                dfs(i, candidates, ans, temp, remain - candidates[i]);
            }
            if (candidates[i] > remain) {
                return;
            }
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


