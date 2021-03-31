public class Q70 {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
//            System.out.println("p: " + p + " q: " + q + " r: " + r);
        }
        return r;
    }

    public static void main(String[] args) {
        int n = 5;
        Q70 q70 = new Q70();
        int ans = q70.climbStairs(n);
        System.out.println(ans);
    }
}


