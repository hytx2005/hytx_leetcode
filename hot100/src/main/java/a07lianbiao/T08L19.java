package a07lianbiao;

import a07lianbiao.base.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class T08L19 {
    /**
     * 栈
     * @param head
     * @param n
     * @return {@link ListNode }
     */
    public static ListNode test1(ListNode head,int n){
        Deque<ListNode> stack = new LinkedList<>();
        ListNode newHead = new ListNode(-1,head);
        ListNode curr = newHead;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        while (n > 0){
            stack.pop();
            n--;
        }
        ListNode last = stack.peek();
        last.next = last.next.next;
        return newHead.next;
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return {@link ListNode }
     */
    public static ListNode test2(ListNode head,int n){
        ListNode newHead = new ListNode(-1,head);
        ListNode curr = newHead;
        ListNode fast = newHead;
        ListNode prev = newHead;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        while (fast != null){
            prev = curr;
            curr = curr.next;
            fast = fast.next;
        }
        prev.next = curr.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = test2(head,2);
        res.print();
    }
}
