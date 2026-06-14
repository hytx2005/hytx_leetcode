package month202606.week2.day13;

public class L19 {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dammy = new ListNode(-1, head);
            // 间隔n的快慢指针
            ListNode fast = dammy;
            while (n > 0) {
                fast = fast.next;
                n--;
            }
            // 快慢指针一起走，直到快指针到达末尾，此时慢指针的下一个节点就是需要删除的节点，快节点是末尾节点
            ListNode slow = dammy;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dammy.next;
        }
    }
}
