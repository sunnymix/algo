package w01.c03stack;

import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(Solution01.evalRPN(new String[]{"1", "2", "+", "3", "*"}));
        System.out.println(Solution01.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static class Solution01 {
        public static int evalRPN(String[] tokens) {
            Stack<Integer> stk = new Stack<>();
            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    // 注意操作数的顺序
                    int y = stk.pop();
                    int x = stk.pop();
                    int res = calc(x, y, token);
                    stk.push(res);
                } else {
                    stk.push(Integer.valueOf(token));
                }
            }
            return stk.peek();
        }

        private static int calc(int x, int y, String op) {
            if (op.equals("+")) {
                return x + y;
            } else if (op.equals("-")) {
                return x - y;
            } else if (op.equals("*")) {
                return x * y;
            } else if (op.equals("/")) {
                return x / y;
            }
            return 0;
        }
    }
}
