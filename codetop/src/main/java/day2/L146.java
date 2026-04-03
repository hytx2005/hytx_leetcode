package day2;

import java.util.HashMap;

public class L146 {
    class LRUCache {
        ListNode head;
        ListNode tail;
        HashMap<Integer,ListNode> map;
        int size;

        class ListNode {
            public ListNode prev;
            public ListNode next;
            public int val;
            public int key;

            public ListNode() {

            }

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            size = capacity;
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                ListNode val = map.get(key);
                // 使用过，加到首部
                val.prev.next = val.next;
                val.next.prev = val.prev;
                ListNode temp = head.next;
                temp.prev = val;
                val.next = temp;
                head.next = val;
                val.prev = head;
                return val.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            // 需要删除元素
            if(map.size() >= size && !map.containsKey(key)){
                ListNode temp = tail.prev;
                temp.prev.next = tail;
                tail.prev = temp.prev;
                map.remove(temp.key);
            }
            // 修改元素
            if(map.containsKey(key)){
                // 移除元素，后面逻辑跟新增一样
                ListNode thisNode = map.get(key);
                thisNode.prev.next = thisNode.next;
                thisNode.next.prev = thisNode.prev;
                map.remove(key);
            }

                ListNode val = new ListNode(key,value);
                ListNode temp1 = head.next;
                temp1.prev = val;
                val.next = temp1;
                head.next = val;
                val.prev = head;
                map.put(key,val);
        }
    }

    public static void main(String[] args) {

    }
}
