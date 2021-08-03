package algorithms;
/**
 * 题目描述:
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class Q131 {


    List<List<String>> res = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }
        backTracking(s, len, 0);
        return res;
    }

    void backTracking(String s, int len, int startIndex) {

        if (startIndex == len) { // 递归停止
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < len; i++) {
            if (!isPalindrome(s.substring(startIndex, i + 1))) { // 剪枝
                continue;
            }
            path.addLast(s.substring(startIndex, i + 1));
            backTracking(s, len, i + 1); // 递归
            path.removeLast();// 回溯
        }
    }

    boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        Q131 q = new Q131();
        List<List<String>> ans = q.partition(s);
        System.out.println(ans);
    }
}


