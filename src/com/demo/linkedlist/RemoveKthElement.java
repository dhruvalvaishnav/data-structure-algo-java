package com.demo.linkedlist;

/**
 * @author Dhruval Vaishnav Created on 06-12-2024
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 */
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveKthElement {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.val = 10;
        list.next = new ListNode(20);
        list.next.next = new ListNode(30);
        list.next.next.next = new ListNode(40);
        list.next.next.next.next = new ListNode(50);

        System.out.println("Before removing 2nd last element");
        ListNode.printLinkedList(list);
        // removeKthLast(list, 2); // returns void
        list = removeNthFromEnd(list, 2); // returns ListNode
        System.out.println("After removing 2nd last element");
        ListNode.printLinkedList(list);
    }

    private static void removeKthLast(ListNode head, int k) {
        // Edge case: if the list is empty
        if (head == null) {
            return;
        }
        // two pointer slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return; // k is larger than the length of the list
            }
            fast = fast.next;
        }

        // If fast is null, then we need to remove the head
        if (fast == null) {
            head = head.next;
            return;
        }

        // Move both slow and fast pointers one step at a time until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now slow is at the node just before the one we want to remove : 1->2->3->4->5 and k=2 then slow will be at 3
        slow.next = slow.next.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        // two pointers
        ListNode left = dummy;
        ListNode right = head;

        // Move right pointer n steps ahead
        while (k > 0 && right != null) {
            right = right.next;
            k--;
        }

        // update the pointers until right reaches the end
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
