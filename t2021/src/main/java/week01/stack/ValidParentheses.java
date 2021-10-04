package week01.stack;

import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(Solution01.isValid("[](){}{([])}"));
    }

    public static class Solution01 {
        public static boolean isValid(String s) {
            Stack<Character> stk = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '[' || c == '(' || c == '{') {
                    stk.push(c);
                } else {
                    if (stk.isEmpty()) {
                        return false;
                    }
                    if (c == ']' && stk.peek() != '[') {
                        return false;
                    } else if (c == ')' && stk.peek() != '(') {
                        return false;
                    } else if (c == '}' && stk.peek() != '{') {
                        return false;
                    }
                    stk.pop();
                }
            }
            return stk.isEmpty();
        }
    }
}
