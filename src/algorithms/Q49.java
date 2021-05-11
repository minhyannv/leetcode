package algorithms; /**
 * 题目描述:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

import java.util.*;

public class Q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedArr = new String(arr); //字符串排序
            List<String> list = map.getOrDefault(sortedArr, new ArrayList<String>());
            list.add(str);
            map.put(sortedArr, list); // 以排序字符串作为key，未排序字符串作为value添加进map

        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Q49 q = new Q49();
        List<List<String>> ans = q.groupAnagrams(strs);
        System.out.println(ans);
    }
}


