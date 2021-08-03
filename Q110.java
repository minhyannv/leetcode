package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点'的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：true
 */

public class Q110 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left); //左子树高度
        int right = dfs(root.right);//右子树高度
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) { //左子树不平衡，右子树不平衡，当前节点不平衡都返回-1
            return -1;
        } else { //返回当前节点的最大高度
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);

        Q110 q = new Q110();
        boolean ans = q.isBalanced(root);
        System.out.println(ans);

    }
}
