package com.demo.trees;

// Serialize and Deserialize Binary Tree
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Serialization is the process of converting a data structure or object into a sequence of bits so that
// it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

import java.util.*;

public class SerializeDeserializeBST {
    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Initialize the Codec
        // Serialize the BST
        String serialized = serialize(root);
        System.out.println("Serialized BST: " + serialized);

        // Deserialize the BST
        TreeNode deserializedRoot = deserialize(serialized);
        String deserializedSerialized = serialize(deserializedRoot);
        System.out.println("Deserialized and then serialized again: " + deserializedSerialized);

        // Check if the serialization of the deserialized tree matches the original
        System.out.println("Is the original serialized string equal to the deserialized? " + serialized.equals(deserializedSerialized));
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll(); //Retrieves and removes the head of this queue
        if (val != null && val.equalsIgnoreCase("n")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("n,");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

}