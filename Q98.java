package algorithms; /**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */

import algorithms.TreeNode;

public class Q98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode treeNode, Long lower, Long upper) {

        if (treeNode == null) {
            return true;
        }
        if (treeNode.val <= lower || treeNode.val >= upper) {
            return false;
        }
        return dfs(treeNode.left, lower, (long) treeNode.val) && dfs(treeNode.right, (long) treeNode.val, upper);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
//        root.left.left = new algorithms.TreeNode(4);
//        root.left.right = new algorithms.TreeNode(6);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);


        Q98 q = new Q98();
        boolean ans = q.isValidBST(root);
        System.out.println(ans);

    }
}
