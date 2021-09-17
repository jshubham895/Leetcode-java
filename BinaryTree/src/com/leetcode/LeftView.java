package com.leetcode;

public class LeftView {

    Node root;
    static int maxLevel = 0;

    void leftView(){
        leftViewUtil(root,1);
    }

    void leftViewUtil(Node node, int level){
        if(node == null)
            return;

        if(maxLevel < level){
            System.out.print(node.data+" ");
            maxLevel = level;
        }

        leftViewUtil(node.left,level+1);
        leftViewUtil(node.right,level+1);
    }

    public static void main(String[] args) {
        LeftView tree = new LeftView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.left.left = new Node(50);
        tree.root.left.left.left = new Node(60);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.leftView();
    }
}
