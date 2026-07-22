package month202607.week4.day22;

import month202607.week4.ListNode;

public class L21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode curA = list1;
        ListNode curB = list2;
        while (curA != null && curB != null){
            if(curA.val < curB.val){
                cur.next = curA;
                curA = curA.next;
            }else {
                cur.next = curB;
                curB = curB.next;
            }
            cur = cur.next;
        }
        curA = curB == null ? curA : curB;
        while (curA != null){
            cur.next = curA;
            curA = curA.next;
            cur = cur.next;
        }
        return head.next;
    }
}
