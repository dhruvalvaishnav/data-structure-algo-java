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

        System.out.print("Nodes of the original LinkedList are : ");
        ListNode.printLinkedList(head);

        ListNode result = reverseListIteratively(head);
//        ListNode result = SolutionReverseLL.reverseListRecursively(head);
        System.out.print("Nodes of the reversed LinkedList are : ");
        ListNode.printLinkedList(result);
    }

    //iteratively - T O(n) & M O(1)
    public static ListNode reverseListIteratively(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
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

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " <=> ");
            current = current.next;
        }
        System.out.println(); // For a newline at the end
    }
}



