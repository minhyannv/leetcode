package algorithms; /**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
 */

import algorithms.TreeNode;

public class Q337 {

    public int rob(TreeNode root) {
        /**
         * 动态规划
         * 状态转移方程：
         * o：父节点，f(o):o被选中所获得的收益，g(o):o未被选中所获得的收益
         * o被选中：f(o) = g(l)+g(r)
         * o未被选中：f(o) = max{f(l),g(l)}+max{f(r),g(r)}
         *
         */

        int[] res = dfs(root);
        return Math.max(res[0], res[1]);//最大收益
    }

    private int[] dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return new int[]{0, 0}; //int[0] 被选中的收益，int[1]未被选中的收益
        }
        int[] l = dfs(treeNode.left);
        int[] r = dfs(treeNode.right);
        int selectedVal = treeNode.val + l[1] + r[1];
        int unselectVal = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selectedVal, unselectVal};
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);


        Q337 q = new Q337();
        int ans = q.rob(root);
        System.out.println(ans);

    }
}
