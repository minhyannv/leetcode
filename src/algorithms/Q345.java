package algorithms;

import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;

import java.util.*;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 */


public class Q345 {

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int sLength = s.length();
        int left = 0, right = sLength - 1;

        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            while (!set.contains(sb.charAt(left)) && left < right) {
                left++;
            }
            while (!set.contains(sb.charAt(right)) && right > left) {
                right--;
            }
            char leftChar = sb.charAt(left);
            char rightChar = sb.charAt(right);
            sb.replace(left, left + 1, String.valueOf(rightChar));
            sb.replace(right, right + 1, String.valueOf(leftChar));
            left++;
            right--;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "holle";
        Q345 q = new Q345();
        String ans = q.reverseVowels(s);
        System.out.println(ans);
    }
}
