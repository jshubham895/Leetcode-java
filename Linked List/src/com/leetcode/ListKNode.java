package com.leetcode;

public class ListKNode {

    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;
        while(curr != null && count != k){
            curr = curr.next;
            count++;
        }
        if(count == k){
            curr = reverseKGroup(curr,k);
            while(count-- > 0){
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;

        }
        return head;
    }

    static void printList(ListNode node){
        while(node != null){
            System.out.print(node.val + "-> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListKNode list = new ListKNode();

        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);

        list.printList(head);
        System.out.println("");
        System.out.println("");
        head = reverseKGroup(head,2);
        list.printList(head);


    }
}
