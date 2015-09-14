package edu.bupt.zyq.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/5.
 */
public class LRUCache {

    class ListNode{
        int val, key;
        ListNode pre, next;
        public ListNode(int v, int k){
            this.val = v;
            this.key = k;
        }
    }
    ListNode head = null, tail = null;
    Map<Integer, ListNode> map;
    int cap = 0;
    public LRUCache(int capacity){
        map = new HashMap<Integer, ListNode>(capacity);
        // if(capacity < 1) throw new Exception("ilegal cap");
        this.cap = capacity;
    }

    public void adjust(ListNode foundNode){
        if(foundNode.pre != null){
            foundNode.pre.next = foundNode.next;
            if(foundNode.next != null) foundNode.next.pre = foundNode.pre;
            if(foundNode == tail) tail = tail.pre;
            foundNode.pre = null;
            foundNode.next = head;
            head.pre = foundNode;
            head = foundNode;
        }
    }

    public int get(int key) {
        if(map.containsKey(key)){
            //adjust the list
            adjust(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) adjust(map.get(key));
        else{
            ListNode newNode = new ListNode(value,key);
            map.put(key, newNode);
            newNode.pre = null;
            newNode.next = head;
            if(head != null) head.pre = newNode;
            head = newNode;
            if(tail == null) tail = newNode;
            if(map.size() > cap){
                if(tail.pre != null) tail.pre.next = null;
                map.remove(tail.key);
                tail = tail.pre;
            }
        }
    }

    public static void main(String[] args){
        LRUCache l = new LRUCache(3);
        l.set(1,1);
        l.set(2, 2);
        l.set(3, 3);
        l.set(4, 4);
        l.get(4);
        l.get(3);
        l.get(2);
        l.get(1);

        l.set(5, 5);
        l.get(1);
        l.get(2);
        l.get(3);
        System.out.println(l.get(2));
    }
}
