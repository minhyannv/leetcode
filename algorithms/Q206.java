package algorithms;

/**
 * 题目描述:
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */


public class Q206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        ListNode l1 = new ListNode(nums1[0]);
        ListNode lh1 = l1;
        for (int i = 1; i < nums1.length; i++) {
            l1.next = new ListNode(nums1[i]);
            l1 = l1.next;
        }

        Q206 q = new Q206();
        ListNode l = q.reverseList(lh1);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

    }
}
