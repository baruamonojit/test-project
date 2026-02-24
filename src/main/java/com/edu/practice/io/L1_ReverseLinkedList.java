package com.edu.practice.io;

import java.util.List;

public class L1_ReverseLinkedList {


    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    private static ListNode solution(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev =  current;
            current = nextTemp;
        }
        return prev;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " => ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {

        // Create: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        head = solution(head);

        System.out.println("Reversed List:");
        printList(head);
    }

}
