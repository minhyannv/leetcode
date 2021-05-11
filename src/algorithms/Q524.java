package algorithms;
/**
 * 题目描述:
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例'2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 */

import java.util.*;

public class Q524 {

//    /**
//     * 借助排序的方法
//     * @param s
//     * @param dictionary
//     * @return
//     */
//    public String findLongestWord(String s, List<String> dictionary) {
//        Collections.sort(dictionary, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) { //先按照长度排序，再按照字典升序排序
//                // 返回相反的compare
//                if (o1.length() > o2.length()) {
//                    return -1;
//                } else if (o1.length() == o2.length()) {
//                    return o1.compareTo(o2);
//                } else {
//                    return 1;
//                }
//            }
//        });
//        for (String s1 : dictionary) {
//            if (isExist(s, s1)) {
//                return s1;
//            }
//        }
//        return "";
//    }

    /**
     * 每次直接记录符合条件的结果
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String s1 : dictionary) {
            if (isExist(s, s1)) {
                if (ans.length() < s1.length()) {
                    ans = s1;
                } else if (ans.length() == s1.length()) {
                    if (ans.compareTo(s1) > 0) {//ans 在s1的字典序之后
                        ans = s1;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 双指针判断s是否包含s1
     *
     * @param s
     * @param s1
     * @return
     */
    private boolean isExist(String s, String s1) {
        int left = 0, right = 0;
        while (left < s.length()) {
            if (s.charAt(left) == s1.charAt(right)) {
                left++;
                right++;
            } else {
                left++;
            }
            if (right == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
//        List<String> dictionary = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"));
        List<String> dictionary = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

        Q524 q = new Q524();
        String ans = q.findLongestWord(s, dictionary);
        System.out.println(ans);
    }
}


