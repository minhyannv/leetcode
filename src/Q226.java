/**
 * 题目描述
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */

public class Q226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 3};
        TreeNode treeNode = new TreeNode(nums[0]);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(4);

        treeNode.right.right = new TreeNode(3);

        Q226 q = new Q226();
        TreeNode ans = q.invertTree(treeNode);
        System.out.println(ans);
    }
}


