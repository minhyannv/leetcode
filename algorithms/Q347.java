import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int idx = 0;
        // 统计数字频次
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        // Map按值排序降序
        Map<Integer, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        // 选取top k
        for (Integer integer : sorted.keySet()) {
            if (idx < k) {
                res[idx++] = integer;
            } else {
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
            System.out.println(an);

        }
    }
}


