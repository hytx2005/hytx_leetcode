package a07lianbiao;

import a07lianbiao.base.ListNode;

import java.util.HashSet;
import java.util.Set;

public class T05L142 {

    /**
     * 哈希
     * @param head
     * @return {@link ListNode }
     */
    public ListNode detectCycle(ListNode head) {
        ListNode cur  = head;
        Set<ListNode> nodes = new HashSet<>();
        while(cur != null){
            if(nodes.contains(cur)){
                return cur;
            }else{
                nodes.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/solutions/1999271/mei-xiang-ming-bai-yi-ge-shi-pin-jiang-t-nvsq">Floyd判环算法</a>
     * @param head
     * @return {@link ListNode }
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                while(slow != head){
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }
}
