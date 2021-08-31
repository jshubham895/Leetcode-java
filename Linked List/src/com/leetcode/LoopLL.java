package com.leetcode;

public class LoopLL {

    static Node head = new Node(0);

    static class Node{

        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static boolean detectLoop(Node head){

        Node slow = head,fast = head;
        int flag = 0;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void detectAndRemove(Node node){
        if (node == null || node.next == null)
            return;

        Node slow = node, fast = node;

        slow = slow.next;
        fast = fast.next.next;

        while(fast != null && fast.next != null){
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast){
            slow = node;
            if (slow != fast){
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }
            else{
                while (fast.next != slow){
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }

    static void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static int lengthLL(Node head){
        if (head == null)
            return 0;

        int count = 0;

        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    static void printList(Node node){
        while(node != null){
            System.out.print(node.data+ "-> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        LoopLL list = new LoopLL();

        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        list.printList(head);
        System.out.println("");

        head.next.next.next.next.next = head.next.next;

        list.detectAndRemove(head);
        list.printList(head);


    }
}
