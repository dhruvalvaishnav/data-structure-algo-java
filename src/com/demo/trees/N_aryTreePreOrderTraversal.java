package com.demo.trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
    https://leetcode.com/problems/n-ary-tree-preorder-traversal

    Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal. Each group of children is
    separated by the null value (See examples)

    Example 1:
                  *1*
            /     |     \
           3       2      4
        /   \
       5     6

    Input: root = [1,null,3,2,4,null,5,6]
    Output: [1,3,5,6,2,4]


    Example 2:
                        *1*
             /      /       \         \
           2        3       4          5
            \        \       |       /   \
             6       7       8      9    10
                     |       |      |
                    11      12     13
                    |
                    14

    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
    Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]

    Constraints:
    The number of nodes in the tree is in the range [0, 104].
    0 <= Node.val <= 104
    The height of the n-ary tree is less than or equal to 1000.

    Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class N_aryTreePreOrderTraversal {
    public static void main(String[] args) {
//        preOrder(root);
    }

    // root-left-right
    public static List<Integer> preOrder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output_arr = new LinkedList<>();

        if (root == null) {
            return output_arr;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output_arr.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return output_arr;
    }
}