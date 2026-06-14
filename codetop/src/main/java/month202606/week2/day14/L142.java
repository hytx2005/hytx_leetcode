package month202606.week2.day14;

public class L142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    ListNode cur = head;
                    while (cur != slow) {
                        slow = slow.next;
                        cur = cur.next;
                    }
                    return cur;
                }
            }
            return null;
        }
    }
}
