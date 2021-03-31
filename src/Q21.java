import java.util.Arrays;
import java.util.Collections;

public class Q21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 3};
        int[] nums2 = {3, 5, 6};
        ListNode l1 = new ListNode(nums1[0]), l2 = new ListNode(nums2[0]);
        ListNode lh1 = l1, lh2 = l2;

        for (int i = 1; i < nums1.length; i++) {
            l1.next = new ListNode(nums1[i]);
            l1 = l1.next;
        }

        for (int i = 1; i < nums2.length; i++) {
            l2.next = new ListNode(nums2[i]);
            l2 = l2.next;
        }

        Q21 q = new Q21();
        ListNode ans = q.mergeTwoLists(lh1, lh2);
        while (ans != null) {
            System.out.print(ans.val + ",");
            ans = ans.next;
        }
//        System.out.println(ans);
    }
}


