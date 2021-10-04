package week01.list;

import common.Print;
import common.model.ListNode;

/**
 * leetcode: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Print.list(mergeTwoList(ListNode.of(new int[]{1, 2, 4}), ListNode.of(new int[]{1, 3, 4})));
        Print.list(mergeTwoList(ListNode.of(new int[]{}), ListNode.of(new int[]{1})));
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode protect = new ListNode(0, null);
        ListNode head = protect;
        while (l1 != null || l2 != null) {
            ListNode newNode = null;
            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                newNode = new ListNode(l1.val, null);
                l1 = l1.next;
            } else {
                newNode = new ListNode(l2.val, null);
                l2 = l2.next;
            }
            head.next = newNode;
            head = head.next;
        }
        return protect.next;
    }
}
