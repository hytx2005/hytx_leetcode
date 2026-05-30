package month202605.day0530;

public class L21 {
    class Solution {
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

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode cur = head;
            ListNode curA = list1;
            ListNode curB = list2;
            while (curA != null && curB != null){
                if(curA.val < curB.val){
                    cur.next = curA;
                    curA = curA.next;
                }else {
                    cur.next = curB;
                    curB = curB.next;
                }
                cur = cur.next;
            }
            curA = curB == null ? curA : curB;
            while (curA != null){
                cur.next = curA;
                curA = curA.next;
                cur = cur.next;
            }
            return head.next;
        }
    }
}
