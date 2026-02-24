package com.edu.practice.io;

public class A3_RemoveNthNodeFromLast {

    private static ListNode solution(ListNode head, int n) {

        ListNode left = head;
        ListNode right = head;
        for (int i=0; i<n;i++) {
            if (right == null) {
                return null;
            }
            right = right.next;
        }

        if (right==null){
            return head.next;
        }

        while (right.next!=null) {
            right = right.next;
            left = left.next;
        }
        left.next=left.next.next;
        return head;
    }

    private static ListNode solution1 (ListNode head, int n) {

        ListNode left = head;
        ListNode right = head;
        for (int i=0; i< n; i++) {
            if (right == null) {
                return null;
            }
            right = right.next;
        }

        if (right == null) {
            return head;
        }

        while (right.next != null ) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        System.out.println(solution1(head, 2));
        System.out.println(solution1(head, 2));
    }
}


class ListNode {
    int val;
    ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }
}