package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKList {

    static Node head;

    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    static void push(int data) {

        Node newNode = new Node(data);

        newNode.prev = null;

        newNode.next = head;

        if (head != null)
            head.prev = newNode;

        head = newNode;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
    }

    static class compareNode implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            return n1.data - n2.data;
        }
    }

    static Node sortAKSortedDLL(Node head, int k) {
        if (head == null)
            return head;

        PriorityQueue<Node> pq = new PriorityQueue<>(new compareNode());

        Node newHead = null, last = null;

        for(int i = 0; head != null && i <= k;i++){
            pq.add(head);
            head = head.next;
        }

        while(!pq.isEmpty()){
            if (newHead == null){
                newHead = pq.peek();
                newHead.prev = null;

                last = newHead;
            }else{
                last.next = pq.peek();
                pq.peek().prev = last;
                last = pq.peek();
            }

            pq.poll();

            if (head != null){
                pq.add(head);

                head = head.next;
            }
        }

        last.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        SortKList list = new SortKList();

        list.push(8);
        list.push(56);
        list.push(12);
        list.push(2);
        list.push(6);
        list.push(3);

        int k = 2;

        System.out.println("Original Doubly linked list:");
        list.printList(head);

        Node sortedDLL = list.sortAKSortedDLL(head, k);
        System.out.println("");
        System.out.println("Doubly Linked List after sorting:");
        list.printList(sortedDLL);
    }
}
