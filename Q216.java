package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述
 * 找出所有相加之和为?n 的?k?个数的组合。组合中只允许含有 1 -?9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。?
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q216 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return res;
    }

    void backTracking(int k, int n, int startIndex, int sum) {
        if (sum > n) { //剪枝
            return;
        }
        if (path.size() == k && sum == n) { //递归终止条件
            res.add(new ArrayList<>(path));
            return;
        }
//        for (int i = startIndex; i <= 9; i++) { //横向遍历
//            path.add(i);
//            sum += i;
//            backTracking(k, n, i + 1, sum); //递归
//            path.removeLast(); //回溯
//            sum -= i;
//        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) { //横向遍历+剪枝
            path.add(i);
            sum += i;
            backTracking(k, n, i + 1, sum); //递归
            path.removeLast(); //回溯
            sum -= i;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        Q216 q = new Q216();
        List<List<Integer>> ans = q.combinationSum3(k, n);
        System.out.println(ans);
    }
}


