package algorithms;

import java.util.List;
import java.util.Stack;

/**
 * 题目描述
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Q234 {


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 0, 0};

        ListNode l1 = null;
        ListNode head = l1;

        for (int i = 1; i < nums1.length; i++) {
            if (l1 == null) {
                l1 = new ListNode(nums1[i]);

            } else {
                l1.next = new ListNode(nums1[i]);
                l1 = l1.next;

            }
        }
        Q234 q = new Q234();
        boolean ans = q.isPalindrome(head);
        System.out.println(ans);
    }
}


