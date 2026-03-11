package a07lianbiao;

import a07lianbiao.base.ListNode;

import java.util.PriorityQueue;

public class T13L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (!queue.isEmpty()){
            ListNode curr = queue.poll();
            if(curr.next != null){
                queue.offer(curr.next);
            }
            curr.next = null;
            prev.next = curr;
            prev = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        T13L23 t = new T13L23();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode res = t.mergeKLists(lists);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
