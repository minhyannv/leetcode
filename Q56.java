package algorithms; /**
 * 题目描述:
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

import java.util.Arrays;
import java.util.Comparator;

public class Q56 {

    public int[][] merge(int[][] intervals) {

        // 二维数组根据左值排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) { //如果res是空的，或者interval左值大于res右值
                res[idx + 1] = interval;
                idx++;
            } else {
                res[idx][1] = Math.max(interval[1], res[idx][1]); //合并区间
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Q56 q = new Q56();
        int[][] ans = q.merge(intervals);
        for (int[] an : ans) {
            System.out.println(an[0] + " " + an[1]);
        }
    }
}



