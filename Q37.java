package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述:
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q37 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        backTracking(board, rows, cols);
        return res;
    }

    boolean backTracking(char[][] board, int rows, int cols) {
        for (int i = 0; i < rows; i++) {        // 遍历⾏
            for (int j = 0; j < cols; j++) { // 遍历列
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {     // (i, j) 这个位置放k是否合适
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;                // 放置k
                        if (backTracking(board, rows, cols)) return true; // 如果找到合适⼀组⽴刻返回
                        board[i][j] = '.';              // 回溯，撤销k
                    }
                }
                return false;                           // 9个数都试完了，都不⾏，那么就返回false
            }
        }
        return true; // 遍历完没有返回false，说明找到了合适棋盘位置了
    }

    boolean isValid(int row, int col, char val, char[][] board) {
        for (int i = 0; i < 9; i++) { // 判断⾏⾥是否重复
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) { // 判断列⾥是否重复
            if (board[j][col] == val) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 判断9⽅格⾥是否重复
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {};
        Q37 q = new Q37();
        List<List<String>> ans = q.solveSudoku(board);
        System.out.println(ans);
    }
}
