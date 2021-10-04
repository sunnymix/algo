package week01.list;

import common.Print;
import common.model.ListNode;

/**
 * leetcode: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode list = ListNode.of(new int[]{1, 2, 3, 4, 5, 6});
        Print.list(list);
        ListNode res = Solution01.reverseKGroup(list, 2);
        Print.list(res);
    }

    public static class Solution01 {
        /**
         * 思路：
         * 1. 分组：往后走k-1步，找到一组的开头head，结尾end
         * 2. 一组内部要反转：从开头head到结尾end之间反转
         * 3. 更新每组跟前一组、后一组之间的边
         *
         * @param head 头节点
         * @param k    分组大小
         * @return 分组反转之后的链表
         */
        public static ListNode reverseKGroup(ListNode head, int k) {
            ListNode protect = new ListNode(0);
            ListNode last = protect;
            // 分组遍历
            while (head != null) {
                // 1. 分组：往后走k-1步，找到一组的开头head，结尾end
                ListNode end = getEnd(head, k);
                if (end == null) {
                    break;
                }
                ListNode nextGroupHead = end.next;
                // 2. 一组内部要反转：从开头head到结尾end之间反转
                reverseList(head, nextGroupHead);
                // 3. 更新每组跟前一组、后一组之间的边
                last.next = end;
                head.next = nextGroupHead;
                // 分组遍历
                last = head;
                head = nextGroupHead;
            }
            return protect.next;
        }

        /**
         * 获取一组最后的节点
         *
         * @param head 头节点
         * @param k    分组大小
         * @return 分组的结尾end，返回null表示不够一组
         */
        public static ListNode getEnd(ListNode head, int k) {
            while (head != null) {
                k--;
                if (k == 0) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }

        /**
         * 内部反转链表
         *
         * @param head 开头
         * @param stop 停止节点（本身不反转）
         */
        public static void reverseList(ListNode head, ListNode stop) {
            ListNode last = head;
            head = head.next;
            while (head != stop) {
                ListNode nextHead = head.next;
                head.next = last;
                last = head;
                head = nextHead;
            }
        }
    }
}
