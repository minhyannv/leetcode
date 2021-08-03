package algorithms;

import java.util.*;

/**
 * 题目描述
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入:?n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q77 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) { //递归终止条件
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) { //横向遍历
            path.add(i);
            backTracking(n, k, i + 1); //递归
            path.removeLast(); //回溯
        }
       /* for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { //剪枝
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }*/
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        Q77 q = new Q77();
        List<List<Integer>> ans = q.combine(n, k);
        System.out.println(ans);
    }
}


