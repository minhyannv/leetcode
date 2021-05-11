package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (i == s.length() - 1) {
                ans += map.get(s.charAt(i));
                break;
            } else if (s.charAt(i) == 'I') {
                if (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X') {
                    ans += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i += 2;
                } else {
                    ans += map.get(s.charAt(i));
                    i += 1;
                }
            } else if (s.charAt(i) == 'X') {
                if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
                    ans += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i += 2;
                } else {
                    ans += map.get(s.charAt(i));
                    i += 1;
                }
            } else if (s.charAt(i) == 'C') {
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
                    ans += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i += 2;
                } else {
                    ans += map.get(s.charAt(i));
                    i += 1;
                }
            } else {
                ans += map.get(s.charAt(i));
                i += 1;
            }


        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        Q13 q = new Q13();
        int ans = q.romanToInt(s);
        System.out.println(ans);
    }
}


