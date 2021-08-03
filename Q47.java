package algorithms;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class Q47 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { //同一父节点的重复子节点不再访问
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
        int[] nums = {1, 1, 2};
        Q47 q = new Q47();
        List<List<Integer>> ans = q.permuteUnique(nums);
        System.out.println(ans);
    }
}


