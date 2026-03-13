package a07lianbiao;

import a07lianbiao.base.ListNode;

public class T06L21 {
    /**
     * 递归
     * @param list1
     * @param list2
     * @return {@link ListNode }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    /**
     * 迭代
     * @param p1
     * @param p2
     * @return {@link ListNode }
     */
    public ListNode mergeTwoLists1(ListNode p1, ListNode p2) {
        if (p1 ==null || p2 == null ){
            return (p1 == null) ? p2 : p1;
        }else {
            ListNode head = null;
            ListNode p1T = p1;
            ListNode p2T = p2;
            // 1.找到头节点
            if(p1.val < p2.val){
                head = p1;
                p1T = p1T.next;
            }else{
                head = p2;
                p2T = p2T.next;
            }
            // 2.遍历构造结果集
            ListNode p = head;
            while(p1T != null && p2T != null){
                if (p1T.val < p2T.val) {
                    p.next = p1T;
                    p1T = p1T.next;
                }else {
                    p.next = p2T;
                    p2T = p2T.next;
                }
                p = p.next;
            }
            // 3.最后的结果集拼接
            if(p1T != null || p2T != null){
                p1T = p1T == null ? p2T : p1T;
                while(p1T != null){
                    p.next = p1T;
                    p1T = p1T.next;
                    p = p.next;
                }
            }
            return head;
        }
    }
}
