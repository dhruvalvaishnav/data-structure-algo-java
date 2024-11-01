package com.demo.linkedlist;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(val); // Just return the value of the node for now
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        HashSet<ListNode> visited = new HashSet<>(); // To track visited nodes

        while (current != null) {
            // If we've already visited this node, break to avoid infinite loop
            if (visited.contains(current)) {
                System.out.println("Cycle detected. Stopping print.");
                break;
            }

            System.out.print(current.val + " <=> ");
            visited.add(current); // Mark this node as visited
            current = current.next;
        }
    }

}
