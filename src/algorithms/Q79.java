package algorithms;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 */

public class Q79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];//初始全为False
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) { //从匹配的首字母开始递归
                    boolean res = dfs(i, j, 0, word, board, visited);
                    if (res) { //找到了匹配字符串
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int i, String word, char[][] board, boolean[][] visited) {

        if (i == word.length()) { //完成匹配则返回
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) { //越界，停止递归
            return false;
        }
        if (word.charAt(i) != board[row][col]) { //当前元素不等于word[i]，停止递归
            return false;
        }
        if (visited[row][col]) { // 标记数组被访问，停止递归
            return false;
        }
        visited[row][col] = true;
        //继续往四个方向递归搜索
        boolean res = dfs(row, col + 1, i + 1, word, board, visited) || dfs(row + 1, col, i + 1, word, board, visited) ||
                dfs(row, col - 1, i + 1, word, board, visited) || dfs(row - 1, col, i + 1, word, board, visited);
        visited[row][col] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        Q79 q = new Q79();
        boolean ans = q.exist(board, word);
        System.out.println(ans);
    }
}


