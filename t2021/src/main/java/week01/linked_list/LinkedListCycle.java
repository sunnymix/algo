package week01.linked_list;

import common.model.ListNode;

/**
 * leetcode: https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode cycle = ListNode.cycle1();
        System.out.println(Solution01.hasCycle(cycle));
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
