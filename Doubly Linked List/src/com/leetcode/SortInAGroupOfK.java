package com.leetcode;

public class SortInAGroupOfK {

    static class Node{

        int data;
        Node next,prev;
    }

    static Node getNode(int data){
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = newNode.prev =  null;
        return newNode;
    }

    static Node push(Node head, Node newNode){
        newNode.prev = null;
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;

        return head;
    }

    static Node reverseList(Node head){
        if (head == null || head.next == null)
            return null;

        Node newHead = null;
        Node current = head;
        Node next;

        while(current != null){
            next = current.next;

            newHead = push(newHead,current);

            current = next;
        }

        head = newHead;

        return head;
    }

    static void printList(Node head){
        while(head != null){
            System.out.print(head.data + ", ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = push(head,getNode(2));
        head = push(head,getNode(4));
        head = push(head,getNode(8));
        head = push(head,getNode(10));

        printList(head);
        System.out.println("");

        head = reverseList(head);
        printList(head);
    }

}
