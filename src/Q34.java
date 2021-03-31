
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q34 {

    public int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] != target) {
                left++;
            } else {
                break;
            }
        }
        while (right > left) {
            if (nums[right] != target) {
                right--;
            } else {
                break;
            }
        }
        if (left == nums.length - 1 && nums[left] != target) {
            return ans;
        }
        ans[0] = left;
        ans[1] = right;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Q34 q = new Q34();
        int[] ans = q.searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}


