package com.demo.linkedlist;

/*  https://leetcode.com/problems/middle-of-the-linked-list/

    Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.

    Example 2:
    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

    Constraints:
    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100

 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        System.out.println("middle node from list is : " + middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        System.out.println("middle node from list is : " + middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
        System.out.println("middle node from  list is : " + middleNode(new ListNode(1, new ListNode(2))));
        System.out.println("middle node from  list is : " + middleNode(new ListNode(1)));

    }

    // hare - tor - problem - where can jump 2 and tor is slow can walk 1
    public static ListNode middleNode(ListNode head) {
        ListNode tor = head, hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tor = tor.next;
        }
        return tor;
    }
}
