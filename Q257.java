package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明:'叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode root, String s, List<String> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(s + root.val);
            return;
        }

        dfs(root.left, s + root.val + "->", ans);
        dfs(root.right, s + root.val + "->", ans);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);

        Q257 q = new Q257();
        List<String> ans = q.binaryTreePaths(root);
        for (String an : ans) {
            System.out.println(an);
        }

    }
}
