import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 */

public class Q461 {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        while (x != 0 || y != 0) {
            if (x == 0) {
                stack.push(0);
            } else {
                stack.push(x % 2);
            }
            x = x / 2;

            if (y == 0) {
                stack.push(0);
            } else {
                stack.push(y % 2);
            }
            y = y / 2;
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(stack.pop())) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        Q461 q = new Q461();
        int ans = q.hammingDistance(x, y);
        System.out.println(ans);
    }
}


