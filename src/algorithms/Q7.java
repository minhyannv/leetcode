package algorithms;

public class Q7 {

    public int reverse(int x) {
        long rev_x = 0;
        while (x != 0) {
            rev_x *= 10;
            int y = x % 10;
//            System.out.println(x + "," + y + "," + rev_x);
            rev_x += y;
            x = (x - y) / 10;
//            System.out.println(x + "," + y + "," + rev_x);
//            System.out.println("===================");
        }
        if (rev_x < Integer.MIN_VALUE || rev_x > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) rev_x;

        }
    }

    public static void main(String[] args) {
        int x = 1534236469;
        Q7 q = new Q7();
        int ans = q.reverse(x);
        System.out.println(ans);
    }
}


