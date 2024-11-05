package com.demo.trees;

/**
 * @author Dhruval Vaishnav Created on 04-11-2024
 * <p>
 * Find the lowest common ancestor of two nodes in a binary tree.
 */
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestor {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(9);
        root.left.right.left.left = new TreeNode(3);
        root.left.right.left.right = new TreeNode(5);

        com.demo.trees.TreeNode.printTree(root);
        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, root.left, root.right);
        //TreeNode lowestCommonAncestor = lowestCommonAncestor(root, root.left.right.left, root);
        System.out.println("Lowest Common Ancestor: " + lowestCommonAncestor.val);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // compare p, q values to curr node, base case: one is in left, other in right subtree, then curr is lca;
        // if both in left, then lca is in left subtree, if both in right, then lca is in right subtree
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null) {
//            return root;
//        }
//        return left != null ? left : right;
//        // time complexity : O(n) for traversing all nodes
//        // space complexity : O(n) for recursive stack

        TreeNode current = root;
        while (current != null) {
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }
}
