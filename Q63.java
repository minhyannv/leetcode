package algorithms;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q63 {

    /**
     * 动态规划
     * dp[i][j]:到达下标i,j的路径数
     * 状态转移方程：
     *
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = 1;
                    }
                } else if (i == 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }

            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Q63 q = new Q63();
        int ans = q.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
    }
}


