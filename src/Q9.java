public class Q9 {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        boolean ans = true;
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                ans = false;
                return ans;
            } else {
                continue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = -121;

        Q9 q = new Q9();
        boolean ans = q.isPalindrome(x);
        System.out.println(ans);
    }
}


