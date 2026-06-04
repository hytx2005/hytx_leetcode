package month202606.day04;



public class L143 {
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
        public void reorderList(ListNode head) {
            // 1.用快慢指针找到链表中点
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode l1 = head;
            ListNode l2 = slow.next;
            slow.next = null;
            l2 = reverse(l2);
            mergeTwoList(l1,l2);
        }

        private void mergeTwoList(ListNode l1, ListNode l2) {
            ListNode l1Temp;
            ListNode l2Temp;
            while (l1 != null && l2 != null){
                l1Temp = l1.next;
                l2Temp = l2.next;

                l1.next = l2;
                l2.next = l1Temp;

                l1 = l1Temp;
                l2 = l2Temp;
            }
        }

        public ListNode reverse(ListNode head){
            ListNode newHead = new ListNode(-1);
            ListNode cur = head;
            while (cur != null){
                ListNode next = cur.next;
                ListNode temp = newHead.next;
                newHead.next = cur;
                cur.next = temp;
                cur = next;
            }
            return newHead.next;
        }
    }
}