package algorithms; /**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 */


import java.util.Arrays;


public class Q148 {

    /**
     * 暴力
     */
    public ListNode sortList(ListNode head) {
        int[] arr = new int[500001];
        ListNode temp = head;
        int idx = -1;
        while (temp != null) {
            arr[++idx] = temp.val;
            temp = temp.next;
        }
        int[] copyArr = Arrays.copyOf(arr, idx + 1);
        Arrays.sort(copyArr);
        temp = head;
        idx = -1;
        while (temp != null) {
            temp.val = copyArr[++idx];
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode head = new ListNode(nums[0]);
        ListNode h1 = head;
        for (int i = 1; i < nums.length; i++) {

            h1.next = new ListNode(nums[i]);
            h1 = h1.next;
        }

        Q148 q141 = new Q148();
        ListNode ans = q141.sortList(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}


