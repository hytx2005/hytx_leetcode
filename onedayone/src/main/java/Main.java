import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static   class LRU{
        ListNode head;
        ListNode tail;
        int size;
        HashMap<Integer,ListNode> map;

        LRU (int capacity){
            size = capacity;
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>(size+1);
        }

        public void put(int key,int val){
            // 1.检查是否存在
            if(map.containsKey(key)){
                ListNode node = map.get(key);
                // 删除，再重新加入
                node.prev.next = node.next;
                node.next.prev = node.prev;
                map.remove(key);
                // 加到首部
                ListNode newNode = new ListNode(key,val);
                ListNode headNext = head.next;
                head.next = newNode;
                newNode.prev = head;
                newNode.next = headNext;
                headNext.prev = newNode;
                map.put(key, newNode);
                return;
            }
            // 不存在
            // 2.1检查容量是否已满
            if(map.size() == size){
                // 去除最久未使用
                ListNode tailPrev = tail.prev;

                tailPrev.prev.next = tail;
                tail.prev = tailPrev.prev;
                map.remove(tailPrev.key);
                put(key,val);
                return;
            }
            // 2.2容量未满，直接加入
            ListNode newNode = new ListNode(key,val);
            ListNode headNext = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = headNext;
            headNext.prev = newNode;
            map.put(key,newNode);
        }

        public int get(int key){
            // 1.检查是否存在
            if(map.containsKey(key)){
                ListNode node = map.get(key);
                // 移除再添加到首部
                node.prev.next = node.next;
                node.next.prev = node.prev;
                map.remove(key);
                // 加到首部
                ListNode newNode = new ListNode(key,node.val);
                ListNode headNext = head.next;
                head.next = newNode;
                newNode.prev = head;
                newNode.next = headNext;
                headNext.prev = newNode;
                map.put(key, newNode);
                return node.val;
            }
            else {
                return Integer.MIN_VALUE;
            }
        }
    }
    public static class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key,int val){
            this.val = val;
            this.key = key;
            prev = null;
            next = null;
        }
        ListNode (int x,ListNode prev,ListNode next){
            val = x;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        // 2被淘汰
        lru.put(3,3);
        //
        System.out.println(lru.get(2));
    }

}
