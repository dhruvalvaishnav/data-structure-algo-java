package com.demo.linkedlist;

/*  https://leetcode.com/problems/merge-two-sorted-lists
    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists in a one sorted list. The list should be made by
    splicing together the nodes of the first two lists.

    Return the head of the merged linked list.

    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    Example 2:
    Input: list1 = [], list2 = []
    Output: []

    Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]

    Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.

 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(list1);
        System.out.println(list2);

        System.out.println(mergeTwoLists(list1, list2));
        System.out.println(mergeTwoLists(new ListNode(), new ListNode()));
        System.out.println(mergeTwoLists(new ListNode(), new ListNode(0, new ListNode())));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // make dummy node
        final ListNode dummy = new ListNode();
        // assign dummy node
        ListNode tail = dummy;

        // loop till both lists can not be null
        while (list1 != null && list2 != null) {
            // if list1 value < list2 -> update tail.next and visa-versa
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            // must update the tail
            tail = tail.next;
        }

        // check if one of them still != null -> directly assign those values in tail
        tail.next = list1 != null ? list1 : list2;
        // return dummy.next
        return dummy.next;
    }
}
