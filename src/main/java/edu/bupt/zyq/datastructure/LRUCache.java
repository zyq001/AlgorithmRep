package edu.bupt.zyq.datastructure;

/**
 * Created by Administrator on 2015/9/5.
 */
public class LRUCache {

    Node head = null, tail = null;
    Map<Integer, Node> hashmap ;
    int cap;
    class Node{//双链表节点
        Node pre, next;
        int val, key;
        Node(int val, int key, Node pre, Node next){
            this.next = next;
            this.pre = pre;
            this.val = val;
            this.key = key;
        }
        void setVal(int val){
            this.val = val;
        }
    }
    public LRUCache(int capacity) {
        hashmap = new HashMap<Integer, Node>();
        cap = capacity;
    }

    public int get(int key) {
        if(!hashmap.containsKey(key)) return -1;
        Node n = hashmap.get(key);
        if(n != head){//是头时不需要调整
            if(n == tail){//要get的在队尾，则需要队尾指针前移以为；当只有一个节点时不用操作
                tail = tail.pre;
                tail.next = null;
            }else
                n.next.pre = n.pre;//只有不是尾的时候才需要调整

            n.pre.next = n.next;//只要不是头就需要调整

            //防止只有一个元素时 自己指自己
            n.next = head;
            head.pre = n;

            n.pre = null;
            head = n;
        }
        return hashmap.get(key).val;

    }

    public void set(int key, int value) {
        if(hashmap.containsKey(key)){//已存在
            Node n = hashmap.get(key);
            if(n != head){//是头时不需要调整
                if(n == tail){//要get的在队尾，则需要队尾指针前移以为；当只有一个节点时不用操作
                    tail = tail.pre;
                    tail.next = null;
                }else
                    n.next.pre = n.pre;//只有不是尾的时候才需要调整

                n.pre.next = n.next;//只要不是头就需要调整

                //防止只有一个元素时 自己指自己
                n.next = head;
                head.pre = n;

                n.pre = null;
                head = n;
            }
            n.setVal(value);
        }else{//不存在
            if(hashmap.size() == cap){//已达容量，删除最早的
                hashmap.remove(tail.key);
                if(tail.pre != null)
                    tail = tail.pre;
                tail.next = null;
            }
            Node newNode = new Node(value, key, null, head);
            if(hashmap.size() == 0){
                tail = newNode;
                head = newNode;
            }else{
                head.pre = newNode;
                newNode.next = head;
                head = newNode;
            }
            hashmap.put(key, newNode);

        }
    }

}
