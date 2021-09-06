package com.leetcode;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LLUtil{

    public Node createLL(int[] a){
        Node head = new Node(a[0]);
        Node temp = head;

        Node newNode = null;
        for (int i = 1; i < a.length; i++) {
            newNode = new Node(a[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

    public void printLL(Node head){
        while(head != null){
            System.out.print(head.data + ", ");
            head = head.next;
        }
        System.out.println("");
    }
}

public class DeleteNodesOnRight {
    public static void main(String[] args) {
        int[] a = {12,15,10,11,5,6,2,3};
        LLUtil ll = new LLUtil();
        Node head = ll.createLL(a);
        ll.printLL(head);
        head = deleteNodesOnRightSide(head);
        ll.printLL(head);
    }

    public static Node deleteNodesOnRightSide(Node head){
        if (head == null || head.next == null)
            return head;

        Node nextNode = deleteNodesOnRightSide(head.next);
        if (nextNode.data > head.data)
            return nextNode;
        head.next = nextNode;

        return head;
    }
}
