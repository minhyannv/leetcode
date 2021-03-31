import java.util.HashMap;
import java.util.Stack;

/**
 * Q155
 */


class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            stack.push(val);

        } else {
            int minVal = stack.peek();
            if (val < minVal) {
                stack.push(val);// 最小值对应的元素
                stack.push(val);// 最小值
            } else {
                stack.push(val);// 最小值对应的元素
                stack.push(minVal);// 最小值
            }

        }
    }

    public void pop() {
        stack.pop();// 最小值
        stack.pop();// 最小值对应的元素
    }

    public int top() {
        int temp1 = stack.pop(); // 最小值
        int temp2 = stack.pop(); // 最小值对应的元素
        stack.push(temp2);
        stack.push(temp1);

        return temp2;

    }

    public int getMin() {

        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}