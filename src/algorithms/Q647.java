package algorithms;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * }
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class Q647 {

    public int countSubstrings(String s) {
        if (s.equals("")) {
            return 0;
        }
        return dfs(s) + countSubstrings(s.substring(1));
    }

    private int dfs(String s) {
        if (s.equals("")) {
            return 0;
        }
        int ans = 0;
        ans += judge(s);
        return ans + dfs(s.substring(0, s.length() - 1));
    }

    private int judge(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 0, j = charArr.length - 1; i < j; i++, j--) {
            if (charArr[i] != charArr[j]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "hello";
        Q647 q = new Q647();
        int ans = q.countSubstrings(s);
        System.out.println(ans);
    }
}


