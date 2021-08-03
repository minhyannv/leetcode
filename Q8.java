package algorithms;

public class Q8 {

    public int myAtoi(String s) {

        long ans = 0;
        boolean flag = true;
        if (s.length() == 1 && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '+' && Character.isDigit(s.charAt(i + 1))) {
                continue;
            }
            if (s.charAt(i) == '+' && !Character.isDigit(s.charAt(i + 1))) {
                return 0;
            }

            if (s.charAt(i) == '-' && Character.isDigit(s.charAt(i + 1))) {
                flag = false;
                continue;
            }
            if (s.charAt(i) == '-' && !Character.isDigit(s.charAt(i + 1))) {
                return 0;
            }
            if (Character.isDigit(s.charAt(i)) && !Character.isDigit(s.charAt(i + 1))) {
                return 0;
            }
            if (Character.isDigit(s.charAt(i))) {
                ans = ans * 10 + Character.getNumericValue(s.charAt(i));
//                System.out.println(ans);
            } else {
                break;
            }
        }
        if (flag == false) {
            ans = -ans;
        }
        if (ans < Math.pow(-2, 31)) {
            return (int) Math.pow(-2, 31);
        } else if (ans > Math.pow(2, 31)) {
            return (int) Math.pow(2, 31);
        } else {
            return (int) ans;
        }

    }

    public static void main(String[] args) {
        String s = "42";
        Q8 q = new Q8();
        int ans = q.myAtoi(s);
        System.out.println(ans);
    }
}


