package month202607.week4.day23;

import month202607.week4.ListNode;

public class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dammy = new ListNode(-1,head);
        ListNode cur = dammy;
        while(n > 0){
            cur = cur.next;
            n--;
        }
        ListNode slow =dammy;
        ListNode fast = cur;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dammy.next;
    }
}
