/**
 * 题目描述:
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q22 {


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int open = 0, close = 0;
        dfs(n, "", res, open, close);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        if (open < close || open > n) {  // 剪枝
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;//回溯
        }

        dfs(n, path + "(", res, open + 1, close);

        dfs(n, path + ")", res, open, close + 1);
    }

    public static void main(String[] args) {
        int n = 2;
        Q22 q = new Q22();
        List<String> ans = q.generateParenthesis(n);
        for (String an : ans) {
            System.out.print(an + " ");
        }
    }
}


