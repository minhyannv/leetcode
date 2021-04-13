package algorithms;

/**
 * 题目描述
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意:合并必须从两个树的根节点开始。
 */
public class Q617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 3};

        TreeNode root1 = new TreeNode(nums[0]);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(4);

        root1.right.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(nums[0]);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);

        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);

        root2.right.right = new TreeNode(3);

        Q617 q = new Q617();
        TreeNode ans = q.mergeTrees(root1, root2);

        System.out.println(ans);
    }
}


