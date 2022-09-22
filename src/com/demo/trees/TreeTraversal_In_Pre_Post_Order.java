package com.demo.trees;


// Java program for different tree traversals
public class TreeTraversal_In_Pre_Post_Order {
    // Root of Binary Tree
    Node1 root;

    TreeTraversal_In_Pre_Post_Order() {
        root = null;
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node1 node) {
        if (node == null) return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node1 node) {
        if (node == null) return;

        /* first print the data of node */
        System.out.print(node.key + " ");

        /* then recur on left child */
        printPreorder(node.left);

        /* now recur on right child */
        printPreorder(node.right);
    }

    /* Given a binary tree, print its nodes in postorder*/
    void printPostorder(Node1 node) {
        if (node == null) return;

        /* first recur on left child */
        printPostorder(node.left);

        /* now recur on right child */
        printPostorder(node.right);

        /* then last print the data of node */
        System.out.print(node.key + " ");
    }

    // Wrappers over above recursive functions
    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }

    void printPostorder() {
        printPostorder(root);
    }

    // Driver code
    public static void main(String[] args) {
        TreeTraversal_In_Pre_Post_Order tree = new TreeTraversal_In_Pre_Post_Order();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);

        // Function call
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPreorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();

    }
}

/* Class containing left and right child of current
   node and key value*/
class Node1 {
    int key;
    Node1 left, right;

    public Node1(int item) {
        key = item;
        left = right = null;
    }
}