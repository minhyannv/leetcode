public class Q104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
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

        Q104 q104 = new Q104();
        int ans = q104.maxDepth(treeNode);
        System.out.println(ans);
    }
}


