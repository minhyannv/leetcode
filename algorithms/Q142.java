package algorithms;
/**
 * 给定一个链表，返回链表开始入环的第一个节点。?如果链表无环，则返回?null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例?2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 */

import java.util.*;

public class Q142 {

//    /**
//     * 哈希表方式
//     */
//    public ListNode detectCycle(ListNode head) {
//        List<ListNode> list = new ArrayList<>();
//        while (head != null) {
//            if (!list.contains(head)) {
//                list.add(head);
//            } else {
//                return head;
//            }
//            head = head.next;
//        }
//        return null;
//    }

    /**
     * 双指针方式
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//        ListNode pre = head;
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = pre.next;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);


        Q142 q = new Q142();
        ListNode ans = q.detectCycle(head);
        System.out.println(ans);
    }
}


