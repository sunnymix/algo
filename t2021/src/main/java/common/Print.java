package common;

import common.model.ListNode;

import java.util.List;
import java.util.Stack;

public class Print {
    public static void line(Object o) {
        System.out.println(o);
    }

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

    public static void list(ListNode head, ListNode cycleStart) {
        StringBuilder res = new StringBuilder();
        boolean meetCycle = false;
        while (head != null) {
            res.append(head.val).append("->");
            if (head.next != null && head.next == cycleStart) {
                if (meetCycle) {
                    res.append(head.next.val).append("(cycle!)");
                    System.out.println(res);
                    return;
                } else {
                    meetCycle = true;
                }
            }
            head = head.next;
        }
        res.append("null");
        System.out.println(res);
    }

    public static void list(List<List<String>> nestStrs) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (List<String> strs : nestStrs) {
            res.append(strs.toString()).append(",");
        }
        if (res.length() > 1) {
            res.delete(res.length() - 1, res.length());
        }
        res.append("]");
        System.out.println(res);
    }

    public static void stack(Stack<Character> stk) {
        System.out.println(stk);
    }
}
