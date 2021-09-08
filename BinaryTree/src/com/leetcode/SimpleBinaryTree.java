package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class SimpleBinaryTree {

    static Node root;
    static Node temp = root;

    SimpleBinaryTree(int data){
        root = new Node(data);
    }

    SimpleBinaryTree(){
        root = null;
    }

    static void inOrder(Node temp){
        if (temp == null)
            return;

        inOrder(temp.left);
        System.out.print(temp.data + ", ");
        inOrder(temp.right);
    }

    static void insert(Node temp,int key){
        if (temp == null) {
            root = new Node(key);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if (temp.left == null){
                temp.left = new Node(key);
                break;
            }
            else{
                q.add(temp.left);
            }

            if (temp.right == null){
                temp.right = new Node(key);
                break;
            }
            else {
                q.add(temp.right);
            }
        }
    }

    static void delete(Node root, int key){
        if (root == null)
            return;

        if (root.left == null && root.right == null){
            if (root.data == key){
                root = null;
                return;
            }
            else
                return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null, keyNode = null;

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if (temp.data == key)
                keyNode = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (keyNode != null){
            int x = temp.data;
            deleteDeepest(root,temp);
            keyNode.data = x;
        }
    }

    static void deleteDeepest(Node root, Node delNode){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if (temp == delNode){
                temp = null;
                return;
            }

            if (temp.right!= null){
                if (temp.right == delNode){
                    temp.right = null;
                    return;
                }
                q.add(temp.right);
            }

            if (temp.left!= null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                }
                q.add(temp.left);
            }
            }
    }


    public static void main(String[] args) {
        SimpleBinaryTree tree = new SimpleBinaryTree();

        insert(root,1);
        insert(root,2);
        insert(root,3);
        insert(root,4);
        delete(root, 3);

        inOrder(root);
    }

}
