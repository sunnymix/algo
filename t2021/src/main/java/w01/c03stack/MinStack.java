package w01.c03stack;

import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack stk = new MinStack();
        stk.push(1);
        stk.push(2);
        stk.pop();
        System.out.println(stk.getMin());
    }

    private Stack<Integer> stk;
    private Stack<Integer> min;

    public MinStack() {
        this.stk = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        this.stk.push(val);
        this.min.push(this.min.isEmpty() ? val : Math.min(val, this.min.peek()));
    }

    public void pop() {
        this.stk.pop();
        this.min.pop();
    }

    public int top() {
        return this.stk.peek();
    }

    public int getMin() {
        return this.min.peek();
    }
}
