package algorithms;

public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return head.next;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }


    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 4, 5};
//        int n = 2;
        int[] nums1 = {1};
        int n = 1;
        ListNode l1 = new ListNode(nums1[0]);
        ListNode head = l1;
        for (int i = 1; i < nums1.length; i++) {
            l1.next = new ListNode(nums1[i]);
            l1 = l1.next;
        }

        Q19 q = new Q19();
        ListNode l = q.removeNthFromEnd(head, n);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }

    }
}
