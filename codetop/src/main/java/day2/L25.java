package day2;

public class L25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode end = head;
        int count = 0;
        while (count < k && end != null) {
            end = end.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode next1 = end;
        ListNode newHead = reverse(head, end);
        head.next = reverseKGroup(next1, k);
        return newHead;
    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null && cur != end) {
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }
}
