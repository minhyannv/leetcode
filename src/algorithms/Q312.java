package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组'nums'中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得'nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。'这里的 i - 1 和 i + 1 代表和'i'相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * '
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 * <p>
 * 输入：nums = [1,5]
 * 输出：10
 */
public class Q312 {

    public int maxCoins(int[] nums) {
        /**
         * 每次戳值最小的气球
         * visited表示气球是否被戳破
         */
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int num = 0;
        int ans = 0;
        while (num < len) {

            //寻找未戳破气球最小值及其索引
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < len; i++) {
                if (minVal > nums[i] && !visited[i]) {
                    minVal = nums[i];
                    minIdx = i;
                }
            }
            visited[minIdx] = true; //气球戳破

            int leftIdx = minIdx;//向左找没有被戳破的气球
            while (visited[leftIdx]) {
                leftIdx--;
                if (leftIdx < 0) {
                    break;
                }
            }

            int rightIdx = minIdx;//向右找没有被戳破的气球
            while (visited[rightIdx]) {
                rightIdx++;
                if (rightIdx >= len) {
                    break;
                }
            }

            if (leftIdx < 0) {
                if (rightIdx >= len) {
                    ans += nums[minIdx];
                } else {
                    ans += nums[minIdx] * nums[rightIdx];
                }
            } else {
                if (rightIdx >= len) {
                    ans += nums[leftIdx] * nums[minIdx];
                } else {
                    ans += nums[leftIdx] * nums[minIdx] * nums[rightIdx];
                }
            }
            System.out.println("leftIdx: " + leftIdx + " minIdx: " + minIdx + " rightIdx: " + rightIdx);
            num += 1;
        }
        System.out.println(num);
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 8};
        Q312 q = new Q312();
        int ans = q.maxCoins(nums);
        System.out.println(ans);
    }
}


