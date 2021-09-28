package common.list;

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
        ListNode head = null;
        ListNode last = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode cur = new ListNode(arr[i]);
            if (i == 0) {
                head = last = cur;
            }
            last.next = cur;
            last = cur;
        }
        return head;
    }
}
