public class Q53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-1, -2};

        Q53 q53 = new Q53();
        int ans = q53.maxSubArray(nums);
        System.out.println(ans);
    }
}


