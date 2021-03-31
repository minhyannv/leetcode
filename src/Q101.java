import java.util.HashSet;
import java.util.Set;

public class Q101 {

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
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

        Q101 q101 = new Q101();
        boolean ans = q101.isSymmetric(treeNode);
        System.out.println(ans);
    }
}


