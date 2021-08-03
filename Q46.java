package algorithms; /**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

import java.util.*;

public class Q46 {
    //
//    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        List<List<Integer>> ans = new ArrayList<>();
//        if (len == 0) {
//            return ans;
//        }
//        Stack<Integer> path = new Stack<>(); // 树路径
//        boolean[] used = new boolean[len]; //是否访问
//        dfs(nums, ans, 0, len, used, path);
//        return ans;
//    }
//
//    private void dfs(int[] nums, List<List<Integer>> ans, int depth, int len, boolean[] used, Stack<Integer> path) {
//        if (depth == len) { //树深最大
//            ans.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < len; i++) {
//            if (used[i]) { // 如果当前数已尽被访问
//                continue;
//            }
//            path.add(nums[i]);
//            used[i] = true;
//            dfs(nums, ans, depth + 1, len, used, path);
//            path.pop();
//            used[i] = false;
//        }
//    }
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        boolean[] visited = new boolean[len];
        backTracking(nums, len, visited);
        return res;
    }

    private void backTracking(int[] nums, int len, boolean[] visited) {
        if (path.size() == len) { //递归停止
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) { //剪枝:同一树枝已经访问的不再访问
                continue;
            }
            path.addLast(nums[i]);
            visited[i] = true;
            backTracking(nums, len, visited); //递归
            path.removeLast(); //回溯
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q46 q = new Q46();
        List<List<Integer>> ans = q.permute(nums);
        System.out.println(ans);
    }
}


