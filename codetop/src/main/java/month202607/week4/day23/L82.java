package month202607.week4.day23;

import month202607.week4.ListNode;

public class L82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dammy = new ListNode(-1);
        ListNode left = head;
        ListNode right = head.next;
        ListNode cur = dammy;
        while(right != null){
            if(right.val != left.val){
                cur.next = left;
                cur = cur.next;
                left = left.next;
                right = right.next;
            }else{
                while(right != null && right.val == left.val){
                    right = right.next;
                }
                // 尾节点是重复节点
                if(right == null){
                    cur.next = null;
                    return dammy.next;
                }
                left = right;
                right = left.next;
            }
        }
        // 尾节点不是重复节点，此时需要拼接，此时尾部为left
        cur.next = left;
        return dammy.next;
    }
}
