package week01.linked_list;

import common.model.ListNode;

/**
 * leetcode: https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(Solution01.hasCycle(n1));
        n4.next = n2;
        System.out.println(Solution01.hasCycle(n1));
    }

    public static class Solution01 {
        public static boolean hasCycle(ListNode head) {
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                head = head.next;
                if (fast == head) {
                    return true;
                }
            }
            return false;
        }
    }
}
