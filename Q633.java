package algorithms;

import java.util.Arrays;

/**
 * 给定一个非负整数'c'，你要判断是否存在两个整数 a 和 b，使得'a2 + b2 = c 。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 */


public class Q633 {

    public boolean judgeSquareSum(int c) {
        /**
         * 双指针题目,用sqrt进行剪纸优化右指针位置
         */

        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {

            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int c = 2;
        Q633 q = new Q633();
        boolean ans = q.judgeSquareSum(c);
        System.out.println(ans);
    }
}
