package algorithms;
/**
 * 题目描述:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class Q40 {


    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates); // 数组排序
        boolean[] used = new boolean[candidates.length];
        backTracking(candidates, 0, target, 0, used);
        return res;
    }

    void backTracking(int[] candidates, int startIndex, int target, int sum, boolean[] used) {
        if (sum > target) { //递归停止
            return;
        }
        if (sum == target) {  //递归停止
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            if (candidates[i] + sum <= target) { //剪枝
                path.addLast(candidates[i]);
                sum += candidates[i];
                used[i] = true;
                backTracking(candidates, i + 1, target, sum, used); //递归
                path.removeLast();
                sum -= candidates[i]; //回溯
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Q40 q = new Q40();
        List<List<Integer>> ans = q.combinationSum2(candidates, target);
        System.out.println(ans);
    }
}


