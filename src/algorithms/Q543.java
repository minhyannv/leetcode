package algorithms;

import algorithms.TreeNode;

public class Q543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ans = {1};
        dfs(root, ans);
        return ans[0] - 1;
    }

    int dfs(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        int L = dfs(root.left, ans);
        int R = dfs(root.right, ans);
        ans[0] = Math.max(ans[0], L + R + 1);
        return Math.max(L, R) + 1;
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

        Q543 q = new Q543();
        int ans = q.diameterOfBinaryTree(treeNode);
        System.out.println(ans);
    }
}


