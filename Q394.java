package algorithms;

import java.util.Collections;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class Q394 {

    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                stack.push(String.valueOf(num));//数字入栈
            }
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.append(new StringBuilder(stack.pop()).reverse()); //出栈时反转
                }
                String reverse = sb.reverse().toString(); //字符串反转
                stack.pop();//出栈‘[’
                stack.push(String.join("", Collections.nCopies(Integer.parseInt(stack.pop()), reverse)));//字符串复制,入栈
            }
            i++;

        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(new StringBuilder(stack.pop()).reverse());
        }
        return ans.reverse().toString();

    }


    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        Q394 q = new Q394();
        String ans = q.decodeString(s);
        System.out.println(ans);
    }
}


