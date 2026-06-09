package month202606.week1.day03;

import java.util.PriorityQueue;

public class L23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
            for (ListNode list : lists) {
                queue.offer(list);
            }
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            while (!queue.isEmpty()){
                ListNode poll = queue.poll();
                cur.next = poll;
                cur = cur.next;
                if(poll.next != null){
                    queue.offer(poll.next);
                }
            }
            return head.next;
        }
    }
}
