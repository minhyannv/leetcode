package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 题目描述:
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */

public class Q451 {
    public String frequencySort(String s) {
        /**
         * 采用桶的思想，桶的长度为字符串长度+1,桶的索引下表对应字符出现频次
         */
        //统计出现频次
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //入桶
        int len = s.length();
        List<Character>[] buckets = new ArrayList[len + 1];
        for (int i = 0; i < len + 1; i++) { //桶初始化
            buckets[i] = new ArrayList<>();
        }
        for (Character character : map.keySet()) {
            buckets[map.get(character)].add(character);
        }
        //出桶
        StringBuilder sb = new StringBuilder();
        for (int i = len; i > 0; i--) {
            List<Character> list = buckets[i];
            if (list.isEmpty()) {
                continue;
            }
            for (Character character : list) {
                sb.append(String.join("", Collections.nCopies(i, String.valueOf(character))));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        Q451 q = new Q451();
        String res = q.frequencySort(s);
        System.out.println(res);

    }
}
