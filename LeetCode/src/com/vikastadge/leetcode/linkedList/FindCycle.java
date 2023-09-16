package com.vikastadge.leetcode.linkedList;

public class FindCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode cycle = new ListNode(2);
        head.next = cycle;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        //head.next.next.next.next = cycle;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("loop exists");
                break;
            }
        }
        System.out.println("loop not exists");
    }
}
