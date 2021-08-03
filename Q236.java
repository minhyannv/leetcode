package algorithms; /**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */

import algorithms.TreeNode;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * left == null 并且 right == null 说明，p与q根本不存在公共祖先。那直接返回null。
         * left == null 并且 right ！= null 。说明其公共祖先就是 right
         * right == null 并且 left ！= null 。说明其公共祖先就是 left
         * right ！= null 并且 left ！=null 。说明right == left = root。return root。
         */
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);


        Q236 q = new Q236();
        TreeNode ans = q.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(ans.val);

    }
}
