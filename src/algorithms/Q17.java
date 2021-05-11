package algorithms;

import java.util.*;

/**
 * 循环+队列
 */
public class Q17 {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return ans;
        }

        Map<Integer, String[]> map = new HashMap<>();
        String[] c2 = {"a", "b", "c"};
        String[] c3 = {"d", "e", "f"};
        String[] c4 = {"g", "h", "i"};
        String[] c5 = {"j", "k", "l"};
        String[] c6 = {"m", "n", "o"};
        String[] c7 = {"p", "q", "r", "s"};
        String[] c8 = {"t", "u", "v"};
        String[] c9 = {"w", "x", "y", "z"};

        map.put(2, c2);
        map.put(3, c3);
        map.put(4, c4);
        map.put(5, c5);
        map.put(6, c6);
        map.put(7, c7);
        map.put(8, c8);
        map.put(9, c9);

        Queue<String> queue = new LinkedList<String>();

        queue.offer(""); // 入队列
        for (int i = 0; i < digits.length(); i++) {
            int size = queue.size(); // 计算队列长度
            for (int j = 0; j < size; j++) {
                String temp = queue.poll(); // 出队列
                String[] strArr = map.get(Integer.parseInt(String.valueOf(digits.charAt(i))));
                for (int k = 0; k < strArr.length; k++) {
                    queue.offer(temp + strArr[k]);
                }
            }

        }
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        String digits = "";
        Q17 q = new Q17();
        List<String> ans = q.letterCombinations(digits);

        System.out.println(ans);
    }
}


