package algorithms;

public class Q11 {

    public int maxArea(int[] height) {
        int ans = -1;
        int l = 0, r = height.length - 1;
        while (l != r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            ans = Math.max(ans, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1, 1};
        Q11 q = new Q11();
        int ans = q.maxArea(height);
        System.out.println(ans);
    }
}


