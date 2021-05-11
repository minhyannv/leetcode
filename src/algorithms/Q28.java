package algorithms;

public class Q28 {

    public int strStr(String haystack, String needle) {
        int ans = -1;
        int num1 = haystack.length();
        int num2 = needle.length();
        if (num1 < num2) {
            return ans;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < num1 - num2 + 1; i++) {
            if (haystack.substring(i, i + num2).equals(needle)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        Q28 q = new Q28();
        int ans = q.strStr(haystack, needle);
        System.out.println(ans);
    }
}


