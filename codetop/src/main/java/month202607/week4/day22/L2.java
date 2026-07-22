package month202607.week4.day22;

import month202607.week4.ListNode;

public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cx = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + cx;
            cur.next = new ListNode(val%10);
            cx = val / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = l1 == null ? l2 : l1;
        while(l1 != null){
            int val = l1.val + cx;
            cur.next = new ListNode(val%10);
            cx = val / 10;
            cur = cur.next;
            l1 = l1.next;
        }
        if(cx != 0){
            cur.next = new ListNode(cx);
            cur = cur.next;
        }
        return head.next;
    }
}
