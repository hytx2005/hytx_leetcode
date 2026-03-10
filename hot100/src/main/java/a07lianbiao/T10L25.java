package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T10L25 {
    /**
     * 递归
     * @param head
     * @param k
     * @return {@link ListNode }
     */
    public static ListNode test1(ListNode head,int k){
        // 如果链表为空，直接返回head
        if(head == null){
            return head;
        }

        // 迭代找到第k个节点
        ListNode curr = head;
        int count = k-1;
        while (count > 0 && curr != null){
            curr = curr.next;
            count--;
        }
        // 结束迭代条件，不满足k个节点，直接返回head
        if(count > 0 || curr == null){
            return head;
        }
        // 反转前k个节点
        ListNode temp = null;
        temp = curr.next;
        ListNode newHead = reverse(head,curr);
        // 递归反转后续链表，并连接到当前链表尾部
        head.next = test1(temp,k);
        return newHead;
    }

    public static ListNode reverse(ListNode head,ListNode end){
        ListNode newHead = new ListNode(-1,null);
        // newHead  p1
        ListNode p1 = head;
        while (p1 != null && p1 != end){
            ListNode next = p1.next;
            p1.next = newHead.next;
            newHead.next = p1;
            p1 = next;
        }
        if(p1 != null){
            p1.next = newHead.next;
            newHead.next = p1;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reverse = test1(head,2);
        reverse.print();
    }
}
