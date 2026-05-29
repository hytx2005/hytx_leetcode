package month202605.day0527;

public class L25 {
    public static class ListNode {
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        int count = 0;
        while (count < k && cur != null) {
            cur = cur.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode next = cur;

        newHead.next = reverse(head, cur);
        ListNode l1 = reverseKGroup(next, k);
        head.next = l1;
        return newHead.next;
    }

    // head 开始节点  end 结束节点(不包)
    public  static ListNode reverse(ListNode head, ListNode end) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null && cur != end) {
            ListNode ne = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = ne;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(-2);
        head.next.next = new ListNode(-3);
        reverseKGroup(head,2);
    }
}
