package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T02L206 {
    public ListNode reverseList(ListNode head) {
        ListNode first = new ListNode(-1,null);
        ListNode p1 = head;
        while(p1 != null){
            ListNode tmp = p1.next;
            p1.next = first.next;
            first.next = p1;
            p1 = tmp;
        }
        return first.next;
    }
}
