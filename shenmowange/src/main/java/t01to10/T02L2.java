package t01to10;

/**
 * 两数相加<a href="https://leetcode.cn/problems/add-two-numbers/description/">...</a>
 *
 * @author ASUS
 */
class T02L2 {
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

    /**
     * 方法一：哨兵节点+模拟加法 时间复杂度：O(max(m,n))，其中 m 和 n 分别是两个链表的长度。空间复杂度：O(max(m,n))，新链表的长度最大为 max(m,n)+1。
     * @param l1 节点1
     * @param l2 节点2
     * @return {@link ListNode }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 哨兵节点
        ListNode head = new ListNode(-1);
        ListNode this1 = head;
        // 进位
        int other = 0;
        while(l1 != null || l2 != null || other != 0){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + other;
            other = sum/10;
            this1.next = new ListNode(sum%10);
            this1 = this1.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;
    }
}
