package month202606.week2.day09;

import com.sun.tools.javac.Main;

public class L82 {


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
        public ListNode deleteDuplicates(ListNode head) {
            // 处理为空 或 只有一个节点的情况
            if(head == null  || head.next == null){
                return head;
            }
            ListNode left = head;
            ListNode right = head.next;
            // 新链表的头节点
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (right != null) {
                if (right.val != left.val) {
                    // left 是唯一节点，可以保留
                    cur.next = left;
                    cur = cur.next;
                    // 移动指针
                    left = left.next;
                    right = right.next;
                } else {
                    // 跳过所有重复节点
                    while (right != null && right.val == left.val) {
                        right = right.next;
                    }
                    // 此时 right 指向第一个不重复节点或 null
                    // left 指向重复节点，需要丢弃
                    if (right == null) {
                        // 后面没有有效节点了
                        cur.next = null;
                        return dummy.next;
                    }
                    left = right;
                    right = right.next;
                }
            }

            // 添加最后一个有效节点
            cur.next = left;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new L82().new ListNode(1);
        ListNode node2 = new L82().new ListNode(2);
        ListNode node3 = new L82().new ListNode(3);
        ListNode node4 = new L82().new ListNode(3);
        ListNode node5 = new L82().new ListNode(4);
        ListNode node6 = new L82().new ListNode(4);
        ListNode node7 = new L82().new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode listNode = new L82().new Solution().deleteDuplicates(node1);
    }
}
