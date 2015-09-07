package edu.bupt.zyq.datastructure;

/**
 * Created by Administrator on 2015/9/5.
 */
public class LRUCache {

    Node head = null, tail = null;
    Map<Integer, Node> hashmap ;
    int cap;
    class Node{//˫����ڵ�
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
        if(n != head){//��ͷʱ����Ҫ����
            if(n == tail){//Ҫget���ڶ�β������Ҫ��βָ��ǰ����Ϊ����ֻ��һ���ڵ�ʱ���ò���
                tail = tail.pre;
                tail.next = null;
            }else
                n.next.pre = n.pre;//ֻ�в���β��ʱ�����Ҫ����

            n.pre.next = n.next;//ֻҪ����ͷ����Ҫ����

            //��ֹֻ��һ��Ԫ��ʱ �Լ�ָ�Լ�
            n.next = head;
            head.pre = n;

            n.pre = null;
            head = n;
        }
        return hashmap.get(key).val;

    }

    public void set(int key, int value) {
        if(hashmap.containsKey(key)){//�Ѵ���
            Node n = hashmap.get(key);
            if(n != head){//��ͷʱ����Ҫ����
                if(n == tail){//Ҫget���ڶ�β������Ҫ��βָ��ǰ����Ϊ����ֻ��һ���ڵ�ʱ���ò���
                    tail = tail.pre;
                    tail.next = null;
                }else
                    n.next.pre = n.pre;//ֻ�в���β��ʱ�����Ҫ����

                n.pre.next = n.next;//ֻҪ����ͷ����Ҫ����

                //��ֹֻ��һ��Ԫ��ʱ �Լ�ָ�Լ�
                n.next = head;
                head.pre = n;

                n.pre = null;
                head = n;
            }
            n.setVal(value);
        }else{//������
            if(hashmap.size() == cap){//�Ѵ�������ɾ�������
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
