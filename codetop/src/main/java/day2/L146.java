package day2;

import java.util.HashMap;

public class L146 {
    static class LRUCache {
        ListNode head;
        ListNode tail;
        HashMap<Integer, ListNode> map;
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

            @Override
            public String toString() {
                return
                        "{ val=" + val +
                        ", key=" + key +"}";
            }
        }

        public LRUCache(int capacity) {
            map = new HashMap(capacity);
            size = capacity;
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                delete(node.key);
                ListNode next = head.next;
                head.next = node;
                node.prev = head;
                node.next = next;
                next.prev = node;
                map.put(key,node);
                return map.get(key).val;
            }
            return -1;
        }

        public void put(int key, int value) {
            // 不存在且无需删除
            if (!map.containsKey(key) && map.size() < size) {
                ListNode next = head.next;
                ListNode newVal = new ListNode(key,value);
                head.next = newVal;
                newVal.prev = head;
                newVal.next = next;
                next.prev = newVal;
                map.put(key,newVal);
            }
            // 不存在且需要删除
            else if(!map.containsKey(key) && map.size() == size){
                ListNode del = tail.prev;
                delete(del.key);
                ListNode next = head.next;
                ListNode newVal = new ListNode(key,value);
                head.next = newVal;
                newVal.prev = head;
                newVal.next = next;
                next.prev = newVal;
                map.put(key,newVal);
            }
            // 存在需要删除重新加入
            else if(map.containsKey(key)){
                ListNode del = map.get(key);
                delete(del.key);
                ListNode next = head.next;
                ListNode newVal = new ListNode(key,value);
                head.next = newVal;
                newVal.prev = head;
                newVal.next = next;
                next.prev = newVal;
                map.put(key,newVal);
            }
        }

        private void delete(int key){
            if(map.containsKey(key)){
                ListNode the = map.get(key);
                map.remove(key);
                the.next.prev = the.prev;
                the.prev.next = the.next;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.map);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.map);;       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 3 作废
        System.out.println(cache.map);;       // 返回 -1 (未找到)
        System.out.println(cache.get(4));       // 返回  4
    }
}
