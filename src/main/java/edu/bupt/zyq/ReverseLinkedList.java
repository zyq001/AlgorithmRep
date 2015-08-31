package edu.bupt.zyq;

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
        ListNode pre = null, next = head.next;
        while(next != null){
            head.next = pre;
            pre = head;
            head = next;
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3), n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        reverse(n1);
    }

}