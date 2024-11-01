package com.demo.linkedlist;

/*
    https://leetcode.com/problems/linked-list-cycle-ii/

    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

    There is a cycle in a linked list if there is some node in the list that can be reached again by
    continuously following the next pointer. Internally, pos is used to denote the index of the node that
    tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

    Do not modify the linked list.

    Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.

    Example 2:
    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.

    Example 3:
    Input: head = [1], pos = -1
    Output: no cycle
    Explanation: There is no cycle in the linked list.

    Constraints:
    The number of the nodes in the list is in the range [0, 104].
    -105 <= Node.val <= 105
    pos is -1 or a valid index in the linked-list.

    Follow up: Can you solve it using O(1) (i.e. constant) memory?

 */

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(10);
        head.next.next.next.next = new ListNode(4); // Last node with value 4
        // Create a cycle: connecting the last node back to the node with value 6
        ListNode cycleStartNode = head.next.next; // Node with value 6
        head.next.next.next.next.next = cycleStartNode; // Last node points to node with value 6

        // missed code for the cycle creation in list so will give ans as null
        // System.out.println(detectCycle(list1));
        ListNode.printLinkedList(head);
        //System.out.println(detectCycleSimple(head));
        System.out.println(hasCycle(head));
        System.out.println(detectCycle2(list1));
        System.out.println(detectCycle2(head));
    }

    private static ListNode detectCycleSimple(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (!set.add(current)) return current;
            current = current.next;
        }
        return null;
        // Time - O(n)
        // Space - O(n)
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        // use tor-hare solution - Floyd Cycle detection
        ListNode tor = head, hare = head, entry = head;
        while (hare.next != null && hare.next.next != null) {
            // find the collision point
            tor = tor.next;
            hare = hare.next.next;
            if (tor == hare) {
                // find the starting point of the cycle
                while (tor != entry) {
                    tor = tor.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }

    // use tor-hare solution - Floyd Cycle detection
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // use tor-hare solution - Floyd Cycle detection
    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (slow != fast) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }


}