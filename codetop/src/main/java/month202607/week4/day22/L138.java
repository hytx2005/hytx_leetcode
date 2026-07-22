package month202607.week4.day22;

import org.w3c.dom.Node;

public class L138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        // 1.节点复制
        // 1->2->3  变成 1->1'->2-2'->3->3'
        Node newHead = head;
        while(newHead != null){
            Node next = newHead.next;
            newHead.next = new Node(newHead.val);
            newHead.next.next = next;
            newHead = next;
        }

        // 2.random节点拷贝
        Node randomHead = head;
        while(randomHead != null){
            randomHead.next.random = randomHead.random == null ? null : randomHead.random.next;
            randomHead = randomHead.next.next;
        }

        // 3.节点拆分
        Node res = new Node(-1);
        Node cur = res;
        Node temp = head;
        // temp cur.next nextTemp nextCur
        while(temp != null){
            Node curNext = temp.next;
            cur.next = curNext;
            temp.next = curNext.next;
            cur = cur.next;
            temp = temp.next;
        }
        cur.next = null;
        return res.next;
    }
}
