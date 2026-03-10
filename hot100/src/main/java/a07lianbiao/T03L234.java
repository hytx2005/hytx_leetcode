package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T03L234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        // 快慢指针找到链表中点
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时情况
        // 1. 链表长度为偶数，slow指向后半部分的第一个节点
        // 2. 链表长度为奇数，slow指向中间节点

        // 特判：链表长度为奇数，slow指向中间节点，此时slow.next才是后半部分的第一个节点
        if (fast != null) {
            prev = slow;
            slow = slow.next;
        }
        // 前半与后半部分断开
        prev.next = null;

        ListNode oldHead = reverseNode(slow);
        ListNode downHead = oldHead;

        ListNode first = head;
        first.print();
        downHead.print();
        boolean res = true;
        while (downHead != null) {
            if (first.val != downHead.val) {
                res = false;
                break;
            }
            first = first.next;
            downHead = downHead.next;
        }

        // 复原
        prev.next = reverseNode(oldHead);

        head.print();
        // 返回结果
        return res;
    }

    public static ListNode reverseNode(ListNode head) {
        ListNode prev = new ListNode(-1, null);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return prev.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1, null)));
        System.out.println(isPalindrome(head));
    }
}

