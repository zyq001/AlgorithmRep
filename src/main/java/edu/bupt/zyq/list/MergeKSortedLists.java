package edu.bupt.zyq.list;

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
	
}