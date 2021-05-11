public class Q38 {

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < res.length(); j++) {
                int count = 1;
                while (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                    j++;
                }
                temp.append(count).append(res.charAt(j));
            }
            res = temp.toString();
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        Q38 q = new Q38();
        String ans = q.countAndSay(n);
        System.out.println(ans);
    }
}


