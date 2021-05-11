package algorithms;

/**
 * 题目描述
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 示例 3：
 * <p>
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * 示例 4：
 * <p>
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 */

public class Q48 {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 深拷贝
        int[][] copyed = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, copyed[i], 0, cols);
        }
        // 顺时针旋转90度后，新位置横坐标是旧位置纵坐标，新位置（列数-旧位置横坐标+1）是旧位置纵坐标
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[j][cols - 1 - i] = copyed[i][j];
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Q48 q = new Q48();
        q.rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}


