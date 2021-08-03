package algorithms;

public class Q35 {

    public int searchInsert(int[] nums, int target) {
        int ans = 0;
        for (int num : nums) {
            if (num < target) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        Q35 q = new Q35();
        int ans = q.searchInsert(nums, target);
        System.out.println(ans);
    }
}


