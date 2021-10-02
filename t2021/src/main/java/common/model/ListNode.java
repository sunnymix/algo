package common.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] arr) {
        ListNode protect = new ListNode(0, null);
        ListNode head = protect;
        for (int i : arr) {
            head.next = new ListNode(i, null);
            head = head.next;
        }
        return protect.next;
    }
}
