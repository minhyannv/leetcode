/**
 * 题目描述:
 * 给定一个非负整数num。对于0 ≤ i ≤ num 范围中的每个数字i，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q338 {
   /*
    =========  暴力   =========
   public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = get_one(i);
        }
        return res;
    }

    private int get_one(int target) {
        int res = 0;
        while (target != 0) {
            res += target % 2;
            target /= 2;
        }
        return res;

    }*/

    /**
     * 动态规划
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1; //奇数的二进制1的个数等于前一个偶数的二进制1的个数+1（偶数+1）
            } else {
                res[i] = res[i / 2]; //偶数的二进制1的个数等于偶数一半的二进制1的个数（只是1右移）
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        Q338 q = new Q338();
        int[] ans = q.countBits(num);
        System.out.print(Arrays.toString(ans));
    }
}


