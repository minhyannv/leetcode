public class Q24 {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            // temp -> node1 -> node2 : temp -> node2 -> node1 : temp = node1
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;

        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        ListNode l1 = new ListNode(nums1[0]);
        ListNode head = l1;
        for (int i = 1; i < nums1.length; i++) {
            l1.next = new ListNode(nums1[i]);
            l1 = l1.next;
        }

        Q24 q = new Q24();
        ListNode l = q.swapPairs(head);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }

    }
}
