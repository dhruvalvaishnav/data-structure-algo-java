package com.demo.neetcode.linkedList;

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
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = SolutionReverseLL.reverseListIteratively(head);
//        ListNode result = SolutionReverseLL.reverseListRecursively(head);
        System.out.println("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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
}

class SolutionReverseLL {
    //iteratively - T O(n) & M O(1)
    public static ListNode reverseListIteratively(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }


    //recursively - T O(n) & M O(n)
    public static ListNode reverseListRecursively(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseListRecursively(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

}