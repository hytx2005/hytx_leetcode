package month202607.week4.day23;

import month202607.week4.ListNode;

public class L25 {
    public  ListNode reverseKGroup(ListNode head, int k) {
        ListNode resHead = new ListNode(-1);
        ListNode cur = head;
        int count = 0;
        while(count < k && cur != null){
            cur = cur.next;
            count++;
        }
        if(count < k ){
            return head;
        }
        resHead.next = reverse(head,cur);
        ListNode h = reverseKGroup(cur,k);
        head.next = h;
        return resHead.next;
    }

    // head 开始节点  end 结束节点(不包)
    public   ListNode reverse(ListNode head, ListNode end) {
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
}
