package algorithms;
/**
 * 题目描述:
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q93 {


    List<String> res = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }
        backTracking(s, len, 0);
        return res;
    }

    void backTracking(String s, int len, int startIndex) {

        if (path.size() > 4) { // 剪枝
            return;
        }
        if (startIndex < len && path.size() == 4) { // 剪枝
            return;
        }
        if (startIndex == len && path.size() == 4) { // 递归停止
            StringBuilder sb = new StringBuilder();
            for (String s1 : path) {
                sb.append(s1).append(".");
            }
            res.add(sb.substring(0, sb.length() - 1).toString());
            return;
        }
        for (int i = startIndex; i < len; i++) {

            if (!isValid(s, startIndex, i)) { //剪枝
                continue;
            }
            path.addLast(s.substring(startIndex, i + 1));
            backTracking(s, len, i + 1); // 递归
            path.removeLast();// 回溯
        }
    }

    boolean isValid(String s, int start, int end) {
        if (s.charAt(start) == '0' && end > start) {//剪枝:排除0开头，并且数长度大于1的情况
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1111";
        Q93 q = new Q93();
        List<String> ans = q.restoreIpAddresses(s);
        System.out.println(ans);
    }
}


