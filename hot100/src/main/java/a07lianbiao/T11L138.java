package a07lianbiao;

import a07lianbiao.base.Node;

import java.util.HashMap;
import java.util.Map;

public class T11L138 {
    public static Node test1(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node newHead = new Node(-1);
        Node newCur = newHead;
        Map<Node,Node> map = new HashMap<>();
        // 拷贝节点的值和next指针
        while (cur != null){
            Node newNode = new Node(cur.val);
            newCur.next = newNode;
            map.put(cur,newNode);
            newCur = newCur.next;
            cur = cur.next;
        }
        // 拷贝random指针
        cur = head;
        newCur = newHead.next;
        while (cur != null){
            newCur.random = map.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.random = head.next.next;
            head.next.random = head;
            head.next.next.random = head.next;
            Node newHead = test1(head);
    }
}
