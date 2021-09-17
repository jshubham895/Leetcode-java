package com.leetcode;

public class TreeTraversals {

    static Node root;

    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static void preOrder(Node head){
        if (head == null)
            return;

        System.out.print(head.data+", ");
        preOrder(head.left);
        preOrder(head.right);
    }

    static void inOrder(Node head){
        if (head == null)
            return;

        inOrder(head.left);
        System.out.print(head.data+", ");
        inOrder(head.right);
    }

    static void postOrder(Node head){
        if (head == null)
            return;

        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.data+", ");
    }

    public static void main(String[] args) {

        TreeTraversals tree = new TreeTraversals();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        preOrder(root);
        System.out.println("");
        inOrder(root);
        System.out.println("");
        postOrder(root);
    }
}
