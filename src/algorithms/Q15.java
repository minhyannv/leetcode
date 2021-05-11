import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //数组排序
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去掉重复数字
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[l]);
                    li.add(nums[r]);
                    ans.add(li);
                    while (l < r && nums[l] == nums[l + 1]) { // 去掉重复数字
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) { // 去掉重复数字
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};

        Q15 q = new Q15();
        List<List<Integer>> ans = q.threeSum(nums);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}


