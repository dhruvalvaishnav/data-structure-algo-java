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

public class LinkedListCycle2 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        // missed code for the cycle creation in list so will give ans as null
        System.out.println(detectCycle(list1));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        // use tor-hare solution
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


}