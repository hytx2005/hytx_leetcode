package month202607.week4.day23;

import month202607.week4.ListNode;

public class L86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode right = head;
        ListNode left = dummy;
        ListNode rightPrev = dummy;
        while (right != null) {
            if (right.val < x) {
                if (left == rightPrev) {
                    // 如果 right 已经在 left 后面，不需要移动
                    left = left.next;
                    rightPrev = rightPrev.next;
                    right = right.next;
                } else {
                    ListNode leftEnd = left.next;
                    rightPrev.next = right.next;
                    left.next = right;
                    left = left.next;
                    left.next = leftEnd;
                    right = rightPrev.next;
                }
            } else {
                rightPrev = rightPrev.next;
                right = right.next;
            }
        }
        return dummy.next;
    }
}
