package month202607.week4.day23;

import month202607.week4.ListNode;

public class L61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = reverse(head);

        // 计算链表长度
        int len = 0;
        ListNode cur = dummy.next;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        if(len <= 1){
            return dummy.next;
        }

        k = k % len;
        if(k == 0){
            return reverse(dummy.next);
        }

        cur = dummy.next;
        while(k > 0){
            cur = cur.next;
            k--;
        }
        ListNode mid = dummy.next;
        dummy.next = reverse(mid,cur);
        mid.next = reverse(cur);
        return dummy.next;
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
    // head 开始节点 翻转整个链表
    public   ListNode reverse(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode ne = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = ne;
        }
        return newHead.next;
    }
}
