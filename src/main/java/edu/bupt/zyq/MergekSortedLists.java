package edu.bupt.zyq;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zangyq on 2015/8/31.
 */
public class MergekSortedLists {

    /**
     * 两种方法：
     * 1,。 分治算法，递归分成两两merge
     * 2， 借助有序队列
     * */
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() < 1 )return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val){
                    return -1;
                }else if(o1.val > o2.val){
                    return 1;
                }
                return 0;
            }
        });

        ListNode head = new ListNode(0), p = head;
        for(ListNode l: lists){
            if(l != null) pq.add(l);
        }
        while(!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            if(p.next != null) pq.add(p.next);
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode[] lists = {new ListNode(1), new ListNode(0)};
//        new MergekSortedLists().mergeKLists(lists);
    }

}
