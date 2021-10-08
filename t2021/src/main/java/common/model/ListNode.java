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

    @Override
    public String toString() {

        return "ListNode{" +
                "val=" + val +
                ", nextVal=" + (next == null ? "null" : next.val) +
                '}';
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

    public static ListNode cycle1() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        return head;
    }
}
