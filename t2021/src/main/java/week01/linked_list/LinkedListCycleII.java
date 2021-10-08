package week01.linked_list;

import common.Print;
import common.model.ListNode;

/**
 * leetcode: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = ListNode.cycle1();
        ListNode cycleStart = detectCycle(head);
        Print.line(cycleStart);
        Print.list(head, cycleStart);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
