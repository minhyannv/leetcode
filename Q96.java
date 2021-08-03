package algorithms; /**
 * 给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 二叉搜索树
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
 * 或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q96 {

    /**
     * 动态规划：
     * dp[i]: 1~i元素组成的二叉搜索树个数
     * 状态转移方程：
     * dp[i]+=dp[j-1]*dp[i-j], j∈{1,i},i∈{1,n}
     * dp[j-1]为以j-1为头结点的二叉搜索树个数，dp[i-j]为以i-j为头结点的二叉搜索树个数
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 3;
        Q96 q = new Q96();
        int ans = q.numTrees(n);
        System.out.println(ans);
    }
}
