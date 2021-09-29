package w01.c02list;

import common.Print;
import common.list.ListNode;

/**
 * leetcode: https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = ListNode.of(new int[]{1, 2, 3, 4, 5});
        Print.list(list);
        ListNode res = Solution01.reverseList(list);
        Print.list(res);
    }

    public static class Solution01 {
        public static ListNode reverseList(ListNode head) {
            ListNode last = null;
            while (head != null) {
                ListNode nextHead = head.next;
                head.next = last;
                last = head;
                head = nextHead;
            }
            return last;
        }
    }
}
