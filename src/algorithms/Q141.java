package algorithms;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行'Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"'行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * '
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */

import java.util.HashSet;
import java.util.Set;


public class Q141 {

//    /**
//     * 借助栈的方法
//     * @param head
//     * @return
//     */
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        Set<ListNode> set = new HashSet<>();
//        while (head.next != null) {
//            if (set.contains(head)) {
//                return true;
//            } else {
//                set.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    /**
     * 双指针方法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode lower = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) { //没有环会退出while循环
            lower = lower.next;
            faster = faster.next.next;
            if (faster == lower) {  //有环一定会追上
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = head;
        Q141 q = new Q141();
        boolean ans = q.hasCycle(head);
        System.out.println(ans);
    }
}


