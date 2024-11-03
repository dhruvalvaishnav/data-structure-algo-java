package com.demo.trees;

//Validate a binary search tree.
//https://leetcode.com/problems/validate-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * <p>
 * A Binary Search Tree (BST) is a node-based binary tree data structure with the following properties.
 * All keys in the left subtree are smaller than the root and all keys in the right subtree are greater.
 * Both the left and right subtrees must also be binary search trees.
 * Each key must be distinct.
 */
public class ValidateBST {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Print the tree
        System.out.println("First Tree:");
        TreeNode.printTree(root);

        // Check if the binary tree is a valid BST
        boolean isValid = isValidBST(root);
        System.out.println("Is the binary tree a valid BST? " + isValid);

        // You can test with another tree
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);

        // Print the tree
        System.out.println("Second Tree:");
        TreeNode.printTree(invalidRoot);

        // Check the invalid tree
        isValid = isValidBST(invalidRoot);
        System.out.println("Is the second binary tree a valid BST? " + isValid);
    }

    public static boolean isValidBST(TreeNode root) {
        return valid(root, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    private static boolean valid(TreeNode node, float left, float right) {
        // Base case: An empty tree is a valid BST
        if (node == null) {
            return true;
        }
        // Check if the current node's value is within the valid range
        if (!(node.val < right && node.val > left)) {
            return false;
        }
        // For the left child, the right bound is the current node's value.
        // For the right child, the left bound is the current node's value.
        return (valid(node.left, left, node.val) && valid(node.right, node.val, right));
    }


}
