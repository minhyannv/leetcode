import java.util.*;

public class Q20 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
//        map.put('(', ')');
        map.put(')', '(');
//        map.put('[', ']');
        map.put(']', '[');
//        map.put('{', '}');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == map.get(c)) { // 栈顶元素
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}}{";
        Q20 q = new Q20();
        boolean ans = q.isValid(s);
        System.out.println(ans);
    }
}


