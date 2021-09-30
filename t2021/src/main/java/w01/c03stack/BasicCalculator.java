package w01.c03stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/basic-calculator/
 */
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(Solution01.calculate("1+2*3"));
        System.out.println(Solution01.calculate("1+2-3"));
    }

    /**
     * 中缀式：1+2*3
     * 后缀式：1 2 3 + *
     * <p>
     * 中缀式：1+2-3
     * 后缀式：1 2 + 3 -
     */
    public static class Solution01 {
        public static int calculate(String s) {
            // 技巧：让末尾的数字可以被放到tokens中去
            s = s + " ";
            Stack<Character> ops = new Stack<>();
            ArrayList<String> tokens = new ArrayList<>();
            String num = "";
            for (Character c : s.toCharArray()) {
                if (isNum(c)) {
                    num = num + c;
                    continue;
                } else {
                    if (!num.isEmpty()) {
                        tokens.add(num);
                        num = "";
                    }
                }
                if (c == ' ') continue;
                int curRank = opRank(c);
                while (!ops.isEmpty() && opRank(ops.peek()) >= curRank) {
                    tokens.add(ops.pop().toString());
                }
                ops.push(c);
            }
            while (!ops.isEmpty()) {
                tokens.add(ops.pop().toString());
            }
            return EvaluateReversePolishNotation.Solution01.evalRPN(tokens.toArray(new String[0]));
        }

        public static boolean isNum(char c) {
            return (int) c >= (int) '0' && (int) c <= (int) '9';
        }

        public static int opRank(char op) {
            if (op == '+' || op == '-') return 1;
            if (op == '*' || op == '/') return 2;
            return 0;
        }
    }
}
