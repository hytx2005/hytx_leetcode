package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T04L141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.val == slow.val){
                return true;
            }
        }
        return false;
    }
}
