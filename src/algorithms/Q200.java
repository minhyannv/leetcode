package algorithms;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = {
 * {'1','1','1','1','0'},
 * {'1','1','0','1','0'},
 * {'1','1','0','0','0'},
 * {'0','0','0','0','0'}
 * }
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = {
 * {'1','1','0','0','0'},
 * {'1','1','0','0','0'},
 * {'0','0','1','0','0'},
 * {'0','0','0','1','1'}
 * }
 * 输出：3
 */
public class Q200 {

    public int numIslands(char[][] grid) {
        /**
         * 深度优先搜索
         * 如果网格中某个值为1，标记之，并依次向四周扩展，对相邻的1标记
         * 寻找其他的1并进行扩展。
         */
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(visited, grid, i, j, row, col);
                    res += 1;
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] visited, char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            dfs(visited, grid, i - 1, j, row, col);
            dfs(visited, grid, i + 1, j, row, col);
            dfs(visited, grid, i, j - 1, row, col);
            dfs(visited, grid, i, j + 1, row, col);

        }
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        Q200 q = new Q200();
        int ans = q.numIslands(grid);
        System.out.println(ans);

    }
}
