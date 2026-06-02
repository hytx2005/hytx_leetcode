package month202606.day02;

public class L92 {
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode cur = head;
            ListNode leftNode = cur;
            ListNode newHead = new ListNode(-1,cur);
            ListNode prev = newHead;
            for (int i = 1; i <= right; i++) {
                if(i == left - 1){
                    prev = cur;
                }
                if (i == left) {
                    leftNode = cur;
                }
                cur = cur.next;
            }
            ListNode end = cur;
            ListNode next = leftNode;

            prev.next = reverse(leftNode,end);
            next.next = end;
            return newHead.next;
        }

        /**
         * 反转链表
         * @param left 左边界
         * @param end 右边界的下一个节点
         * @return {@link ListNode }
         */
        public ListNode reverse(ListNode left,ListNode end){
            ListNode cur = left;
            ListNode head = new ListNode(-1);
            while (cur != null && cur != end){
                ListNode next = head.next;
                ListNode temp = cur.next;
                head.next = cur;
                cur.next = next;
                cur = temp;
            }
            return head.next;
        }
    }
}
