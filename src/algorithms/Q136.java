import java.util.HashSet;
import java.util.Set;

public class Q136 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        for (Integer integer : set) {
            ans = integer;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        Q136 q136 = new Q136();
        int ans = q136.singleNumber(nums);
        System.out.println(ans);
    }
}


