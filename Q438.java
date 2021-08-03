package algorithms;

import java.util.*;

/**
 * 题目描述:
 * 给定一个字符串's'和一个非空字符串'p，找到's'中所有是'p'的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串's'和 p'的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例'1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * '示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Q438 {

    public List<Integer> findAnagrams(String s, String p) {
        /**
         * 滑动窗口+双指针
         *
         */
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int[] sFrequency = new int[26];
        int[] pFrequency = new int[26];
        for (char c : p.toCharArray()) {
            pFrequency[c - '0' - 49] += 1;
        }
        for (int i = 0; i < n - m + 1; i++) {
            String winS = s.substring(i, i + m); //滑动窗口
            for (char c : winS.toCharArray()) { //统计字符频率
                sFrequency[c - '0' - 49] += 1;
            }
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (pFrequency[j] != sFrequency[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(i);
            }
            Arrays.fill(sFrequency, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        Q438 q = new Q438();
        List<Integer> ans = q.findAnagrams(s, p);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }

    }
}
