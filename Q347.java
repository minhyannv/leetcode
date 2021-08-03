package algorithms;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * 题目描述
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */

public class Q347 {

    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int idx = 0;
        // 统计数字频次
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        //创建桶，下标是频次，值是对应频次的元素集合
        List<Integer>[] buckets = new ArrayList[len + 1];
        for (int i = 0; i < len + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Integer integer : map.keySet()) {
            buckets[map.get(integer)].add(integer);
        }

        for (int i = len; i >= 0; i--) {
            List<Integer> temp = buckets[i];
            if (temp.isEmpty()) {
                continue;
            }
            for (Integer integer : temp) {
                res[idx++] = integer;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Q347 q = new Q347();
        int[] ans = q.topKFrequent(nums, k);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}


