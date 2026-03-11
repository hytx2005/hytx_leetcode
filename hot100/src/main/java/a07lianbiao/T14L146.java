package a07lianbiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T14L146 {
    static class LRUCache {
        class LinkedNode {
            int key;
            int val;
            LinkedNode prev;
            LinkedNode next;

            public LinkedNode() {
            }

            public LinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, LinkedNode> map;
        int capacity;//容量
        int length;// 当前数据量
        // 新的放在前面
        LinkedNode head;//头结点
        LinkedNode tail;//尾结点

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
            this.length = 0;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                LinkedNode node = map.get(key);
                moveToHead(node);
                return node.val;
            }
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if(length == capacity){
                    LinkedNode last = removeLast();
                    map.remove(last.key);
                    length--;
                }
                LinkedNode node = new LinkedNode(key, value);
                addToHead(node);
                map.put(key, node);
                length++;
            } else {
                LinkedNode node = map.get(key);
                node.val = value;
                moveToHead(node);
            }
        }

        private void addToHead(LinkedNode node){
            // head <-> head.next
            // head <-> node <-> head.next
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private void removeNode(LinkedNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(LinkedNode node){
            removeNode(node);
            addToHead(node);
        }

        private LinkedNode removeLast(){
            LinkedNode last = tail.prev;
            removeNode(last);
            return last;
        }
    }

    public static void printLRU(LRUCache cache){
        LRUCache.LinkedNode head = cache.head;
        while (head.next != cache.tail){
            head = head.next;
            System.out.print(head.val+"="+head.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        printLRU(cache);
        System.out.println(cache.get(1));
        printLRU(cache);
        cache.put(3, 3);
        printLRU(cache);
        System.out.println(cache.get(2));
        printLRU(cache);
        cache.put(4, 4);
        printLRU(cache);
        System.out.println(cache.get(3));
        printLRU(cache);
        System.out.println(cache.get(4));
    }
}
