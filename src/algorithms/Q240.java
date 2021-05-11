/**
 * 题目描述:
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 */

public class Q240 {

    /**
     * 暴力
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                if (anInt == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 右上往左下找
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int row = 0;
//        int col = matrix[0].length - 1;
//        while (row <= matrix.length - 1 && col >= 0) {
//            if (matrix[row][col] == target) {
//                return true;
//            } else if (matrix[row][col] > target) {
//                col--;
//            } else {
//                row++;
//            }
//        }
//        return false;
//    }

    /**
     * 逐行二分法
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int left = 0, right = ints.length - 1;
            if (ints[left] > target || ints[right] < target) {
                continue;
            }
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        Q240 q = new Q240();
        boolean ans = q.searchMatrix(matrix, target);
        System.out.print(ans);
    }
}


