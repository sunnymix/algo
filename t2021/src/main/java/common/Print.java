package common;

import common.model.ListNode;

import java.util.Stack;

public class Print {
    public static void array(int[] arr) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                res.append(",");
            }
            res.append(arr[i]);
        }
        res.append("]");
        System.out.println(res);
    }

    public static void list(ListNode head) {
        StringBuilder res = new StringBuilder();
        while (head != null) {
            res.append(head.val).append("->");
            head = head.next;
        }
        res.append("null");
        System.out.println(res);
    }

    public static void stack(Stack<Character> stk) {
        System.out.println(stk);
    }
}
