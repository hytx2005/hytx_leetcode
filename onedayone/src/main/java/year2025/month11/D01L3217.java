package year2025.month11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ASUS
 */
public class D01L3217 {
    public static class ListNode {
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

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode newHead = new ListNode(-1,head);
        ListNode cur = newHead;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
            
        }
        return newHead.next;
    }
}
