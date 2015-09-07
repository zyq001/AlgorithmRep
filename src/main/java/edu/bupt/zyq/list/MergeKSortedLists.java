package edu.bupt.zyq.list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by baidu on 15/8/26.
 */
public class MergeKSortedLists {
	
	public static ListNode mergeKsortedLists(ListNode[] lists){
        if(lists == null || lists.length < 1) return null;
        return mergeKsortedLists(lists, 0, lists.length - 1);
    }

    public static  ListNode mergeKsortedLists(ListNode[] lists, int left, int right){
        if(left > right) return null;
        if(left == right) return lists[left];
        int mid = (right + left) / 2;
        ListNode l = mergeKsortedLists(lists, left, mid), r = mergeKsortedLists(lists, mid + 1, right);
        return merge2SortedLists(l, r);
    }

    public  static ListNode merge2SortedLists(ListNode l, ListNode r){
        if(l == null) return r;
        if(r == null) return l;
        ListNode pre = new ListNode(0), p = pre;
        while(l != null || r != null){
            if(l == null){
                p.next = r;
                break;
            }
            if(r == null){
                p.next = l;
                break;
            }
            if(l.val > r.val){
                p.next = r;
                r = r.next;
                p = p.next;
            }else{
                p.next = l;
                l = l.next;
                p = p.next;
            }
        }
        return  pre.next;
    }


    /**
     * Java PriorityQueue
     * */
    public static ListNode mergeKsortedListsP(ListNode[] lists){
        if(lists == null || lists.length < 1) return null;
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val == l2.val? 0 : (l1.val > l2.val? 1: -1);
            }
        });

        ListNode p = new ListNode(0), q = p;
        for(ListNode temp: lists)
            if(temp != null) pq.add(temp);
        while(!pq.isEmpty()){
            ListNode l = pq.poll();
            q.next = l;
            q = q.next;
            if(l.next != null) pq.add(l.next);
        }

        return p.next;
    }
	
}