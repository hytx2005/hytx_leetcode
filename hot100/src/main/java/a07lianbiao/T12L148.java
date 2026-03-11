package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T12L148 {

    /**
     * 递归归并排序，时间复杂度O(nlogn)，空间复杂度O(logn)
     * @param head
     * @return {@link ListNode }
     */
    public ListNode test(ListNode head) {
        return sort(head,null);
    }

    /**
     * 归并排序，左闭右开区间
     * @param head
     * @param end
     * @return {@link ListNode }
     */
    public ListNode sort(ListNode head,ListNode end){
        if(head == null){
            return head;
        }
        if(head.next == end){
            // 断开连接再返回
            head.next = null;
            return head;
        }
        ListNode slow = head,fast = head;
        while (fast != end){
            slow = slow.next;
            fast = fast.next;
            if(fast != end){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = sort(head,mid);
        ListNode right = sort(mid,end);
        return merge(left,right);
    }

    public ListNode merge(ListNode head1,ListNode head2){
       ListNode head = new ListNode(-1);
       ListNode prev = head;
         while (head1 != null && head2 != null){
              if(head1.val <= head2.val){
                prev.next = head1;
                head1 = head1.next;
              }else {
                prev.next = head2;
                head2 = head2.next;
              }
              prev = prev.next;
         }
         if (head1 != null){
             prev.next = head1;
         }else if (head2 != null){
             prev.next = head2;
         }
            return head.next;
    }


    public ListNode test2(ListNode head){
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null){
            length++;
            node = node.next;
        }
        // 哨兵节点
        ListNode dummy = new ListNode(-1,head);
        // 未排序的上一个节点
        ListNode prev = dummy;
        for(int subLength = 1;subLength < length;subLength <<= 1){
            prev = dummy;
            ListNode curr = dummy.next;
            while (curr != null){
                // 1.找两段链表进行合并
                // 1.1找到第一段链表
                ListNode head1 = curr;
                for(int i = 1; i < subLength && curr.next != null; i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                // 1.2找到第二段链表
                for(int i = 1;i < subLength && curr != null && curr.next != null;i++){
                    curr = curr.next;
                }
                // 断开连接
                ListNode next = null;
                if(curr != null){
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merge = merge(head1, head2);
                prev.next = merge;
                while (prev.next != null){
                    prev = prev.next;
                }
                curr = next;
            }
        }

        return dummy.next;
    }
}
