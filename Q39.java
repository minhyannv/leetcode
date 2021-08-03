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

 /*   public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
    }*/

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backTracking(candidates, 0, target, 0);
        return res;
    }

    void backTracking(int[] candidates, int startIndex, int target, int sum) {
        if (sum > target) { //递归停止
            return;
        }
        if (sum == target) {  //递归停止
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] + sum <= target) { //剪枝
                path.addLast(candidates[i]);
                sum += candidates[i];
                backTracking(candidates, i, target, sum); //递归
                sum -= candidates[i]; //回溯
                path.removeLast();
            }

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 7, 6, 3, 5, 1};
        int target = 9;
        Q39 q = new Q39();
        List<List<Integer>> ans = q.combinationSum(candidates, target);
        System.out.println(ans);
    }
}


