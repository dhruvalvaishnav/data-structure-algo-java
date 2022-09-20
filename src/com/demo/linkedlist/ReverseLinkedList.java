package com.demo.linkedlist;

/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Example 2:
    Input: head = [1,2]
    Output: [2,1]

    Example 3:
    Input: head = []
    Output: []

    Constraints:
    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

    Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println("Reversed list is : " + reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        System.out.println("Reversed list is : " + reverseList(new ListNode(1, new ListNode(2))));
        System.out.println("Reversed list is : " + reverseList(new ListNode()));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Reversed list is : " + reverseList2(new ListNode(1)));
        System.out.println("Reversed list is : " + reverseList2(new ListNode(1, new ListNode(2))));
    }

    // T - O(n) && S - O(1) - two pointers - iterative
    public static ListNode reverseList(ListNode head) {
        System.out.println("Given List is : " + head.toString());

        // make two pointers = prev = null and curr = head
        ListNode prev = null, curr = head;
        // loop while curr != null
        while (curr != null) {
            // make tmp var to store curr.next
            ListNode nxt = curr.next;
            // assignment of the pointers
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        // return prev
        return prev;
    }

    // T - O(n) && S - O(n) - recursive
    public static ListNode reverseList2(ListNode head) {
//        System.out.println("Given List is : " + head.toString());

        // if head is null return null  = best case
        if (head == null) return null;
        // make temp new head
        ListNode newHead = head;
        // head.next not null so recursively perform the method execution
        if (head.next != null) {
            newHead = reverseList2(head.next);
            // assign head.next.next to head
            head.next.next = head;
        }
        // make head.next null
        head.next = null;
        // return new head
        return newHead;
    }
}
