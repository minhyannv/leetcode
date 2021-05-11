/**
 * 题目描述:
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 */

import java.util.Arrays;

public class Q221 {
    public int maximalSquare(char[][] matrix) {
        /**
         * 状态转移方程
         * dp(i,j) = min{dp(i-1,j),dp(i,j-1),dp(i-1,j-1)}+1
         * char to int  =>  eg: '5'-'0' = 5
         */
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {  //限制边界值
                    dp[i][j] = matrix[i][j] - '0';
                    if (dp[i][j] > ans) {
                        ans = dp[i][j];
                    }
                    continue;
                }
                if (matrix[i][j] - '0' == 0) {
                    dp[i][j] = 0;
                } else {
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > ans) {
                        ans = dp[i][j];
                    }
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        Q221 q = new Q221();
        int ans = q.maximalSquare(matrix);
        System.out.print(ans);
    }
}


