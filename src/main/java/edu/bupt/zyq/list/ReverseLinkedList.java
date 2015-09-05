package edu.bupt.zyq.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zangyq on 2015/8/25.
 */
public class ReverseLinkedList {

    public static ListNode reverse(ListNode head){
		if(head == null) return head;
		ListNode pre = null, next;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
        return pre;
    }
	
	public ListNode reverseRecursively(ListNode head){
		if(head == null) return head;
		return reverseRecursively(null, head);
	}
	
	public ListNode reverseRecursively(ListNode pre, ListNode now){
		if(now == null) return pre;
		ListNode res = reverseRecursively(now, now.next);
		now.next = pre;
		return res;
	}

    public static void main(String[] args){
//		ListNode
    }

}