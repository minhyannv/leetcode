import java.util.HashSet;
import java.util.Set;


public class Q141 {

    // ÄÚ²¿Àà
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = head;
        Q141 q141 = new Q141();
        boolean ans = q141.hasCycle(head);
        System.out.println(ans);
    }
}


