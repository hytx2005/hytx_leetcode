package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T07L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        int carry = 0;
        int temp = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            temp = val1 + val2 + carry;
            int num = temp % 10;
            carry = temp/10;
            curr.next = new ListNode(num);
            curr = curr.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        while(carry > 0){
            int num = carry %10;
            carry = carry / 10;
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return head.next;
    }
}
