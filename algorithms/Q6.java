public class Q6 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() < 1 || numRows == 1) {
            return s;
        }
        StringBuilder[] array = new StringBuilder[numRows];
        int dir = 1, index = 0;

        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }
        for (char c : s.toCharArray()) { //±éÀú×Ö·û´®s
            array[index].append(c);
            index = index + dir;
            if (index == numRows - 1 || index == 0) {
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Q6 q = new Q6();
        String ans = q.convert(s, numRows);
        System.out.println(ans);
    }
}


