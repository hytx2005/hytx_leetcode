package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T09L24 {
    /**
     * 迭代
     * @param head
     * @return {@link ListNode }
     */
    public static ListNode test1(ListNode head){
        ListNode newHead = new ListNode(-1,head);
        ListNode prev = newHead;
        ListNode curr = head;
        //  prev curr  next nextStep
        //  prev next  curr nextStep
        while (curr != null && curr.next != null){
            ListNode nextStep = curr.next.next;
            ListNode next = curr.next;
            prev.next = next;
            next.next = curr;
            curr.next = nextStep;
            prev = curr;
            curr = nextStep;
        }
        return newHead.next;
    }

    /**
     * 递归
     * @param head
     * @return {@link ListNode }
     */
    public static ListNode test2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = test2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        ListNode res = test2(head);
        res.print();
    }
}
