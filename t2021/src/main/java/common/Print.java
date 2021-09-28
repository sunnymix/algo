package common;

import common.list.ListNode;

public class Print {
    public static void arr(int[] arr) {
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
}
