package algorithms;

public class Q27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                for (int i = l; i < r; i++) {
                    nums[i] = nums[i + 1];
                }
                r--;
            } else {
                l++;
            }
        }
        return r + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
//        int[] nums = {3, 3};
//        int val = 3;
        Q27 q = new Q27();
        int ans = q.removeElement(nums, val);
        for (int i = 0; i < ans; i++) {
            System.out.print(nums[i] + ",");
        }
//        System.out.println(ans);
    }
}


