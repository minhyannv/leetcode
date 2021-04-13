package algorithms; /**
 *  * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
 *  * <p>
 *  * 示例 1：
 *  * <p>
 *  * 输入：root = [1,null,2,3]
 *  * 输出：[1,3,2]
 *  * 示例 2：
 *  * <p>
 *  * 输入：root = []
 *  * 输出：[]
 *  * 示例 3：
 *  * <p>
 *  * 输入：root = [1]
 *  * 输出：[1]
 *  * 示例 4：
 *  * <p>
 *  * <p>
 *  * 输入：root = [1,2]
 *  * 输出：[2,1]
 *  * 示例 5：
 *  * <p>
 *  * <p>
 *  * 输入：root = [1,null,2]
 *  * 输出：[1,2]
 */

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q94 {

    /**
     * 递归方法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, res);
        res.add(treeNode.val);
        dfs(treeNode.right, res);

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);


        Q94 q = new Q94();
        List<Integer> ans = q.inorderTraversal(root);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }

    }
}
