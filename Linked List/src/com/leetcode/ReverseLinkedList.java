package com.leetcode;

public class ReverseLinkedList {

    static Node head;

    static class Node{

        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    static Node reverse(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    static Node reverseRecursive(Node current , Node prev){

        if (head == null)
            return head;

        if (current.next == null){
            head = current;
            current.next = prev;
            return head;
        }

        Node next1 = current.next;
        current.next = prev;
        reverseRecursive(next1,current);
        return head;
    }

    static Node reverseInGroup(Node head, int k)
    {
        if(head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }


        if (next != null)
            head.next = reverseInGroup(next, k);

        return prev;
    }

    static void printList(Node node){
        while(node != null){
            System.out.print(node.data+ "-> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        ReverseLinkedList list = new ReverseLinkedList();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = reverseInGroup(head,2);
        printList(head);

    }
}
