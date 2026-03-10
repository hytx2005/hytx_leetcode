package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T01L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1 != h2){
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        System.out.println(headA+""+headB);
    }
}
