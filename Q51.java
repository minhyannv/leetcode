package algorithms;
/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class Q51 {


    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return res;
        }
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backTracking(n, chessboard, 0);
        return res;
    }

    void backTracking(int n, char[][] chessboard, int row) {
        if (row == n) {
            List<String> arrayList = new ArrayList<>();
            for (char[] chars : chessboard) {
                StringBuilder sb = new StringBuilder();
                for (char aChar : chars) {
                    sb.append(aChar);
                }
                arrayList.add(sb.toString());
            }
            res.add(new ArrayList<>(arrayList));
            return;
        }
        for (int col = 0; col < n; col++) {
            //判断位置是否合法
            if (!isValid(chessboard, n, row, col)) {
                continue;
            }
            chessboard[row][col] = 'Q';
            backTracking(n, chessboard, row + 1);
            chessboard[row][col] = '.';
        }

    }

    public boolean isValid(char[][] chessboard, int n, int row, int col) {
        int count = 0;
        // 检查列
        for (int i = 0; i < row; i++) { // 这是⼀个剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上45度⻆是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右上135度⻆是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public String generateString(int n, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (j != i) {
                sb.append(".");
            } else {
                sb.append("Q");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        Q51 q = new Q51();
        List<List<String>> ans = q.solveNQueens(n);
        System.out.println(ans);
    }
}


