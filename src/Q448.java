import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述:
 * 给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 */


public class Q448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        arr[0] = -1;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Q448 q = new Q448();
        List<Integer> ans = q.findDisappearedNumbers(nums);
        for (Integer an : ans) {
            System.out.println(an);

        }
    }
}
