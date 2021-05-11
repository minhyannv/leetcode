package algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内。
 */

public class Q646 {
    public int findLongestChain(int[][] pairs) {
        /**
         * 动态规划
         * dp[i] 位置0-i对应的最长数对链
         *
         */
        int row = pairs.length;
        int maxLen = 1;
        int[] dp = new int[row];
//        Arrays.sort(pairs, new Comparator<int[]>() { //二维数组升序排序
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) return o1[1] - o2[1];
//                return o1[0] - o2[0];
//            }
//        });
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        for (int i = 0; i < row; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};

        Q646 q = new Q646();
        int ans = q.findLongestChain(pairs);
        System.out.println(ans);
    }
}


