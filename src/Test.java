public class Test {

    public int fun(Integer x) {
        x = x + 1;
        return x;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Integer x = 5;
        int y = test.fun(5);
        System.out.println("x: " + x + " y: " + y);

    }
}
