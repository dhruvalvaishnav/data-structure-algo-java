package com.demo.linkedlist;

import java.util.HashSet;
import java.util.Set;

//Find the intersection point of two linked lists.
// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionPointOfTwoLinkedList {
    public static void main(String[] args) {

        //[4,1,8,4,5]
        //[5,6,1,8,4,5]

        // Create the intersection part
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        // Create listA
        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = intersection; // Link to the intersection node

        System.out.println("Here is the List A : ");
        ListNode.printLinkedList(listA);
        System.out.println();

        // Create listB
        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next = intersection; // Link to the intersection node

        System.out.println("Here is the List B : ");
        ListNode.printLinkedList(listB);
        System.out.println();

        // Find and print the intersection point
        ListNode intersectionPoint = findIntersectionPoint(listA, listB);
        System.out.println("Here is the Intersection Point of Two LinkedLists :");
        if (intersectionPoint != null) {
            System.out.println(intersectionPoint.val); // Print the value of the intersection node
        } else {
            System.out.println("No intersection.");
        }

    }

    private static ListNode findIntersectionPoint(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA, currB = headB;
        // Traverse both lists
        while (currA != currB) {
            // Move to the next node, or switch to the other list if reached the end
            currA = (currA != null) ? currA.next : headB;
            currB = (currB != null) ? currB.next : headA;
        }
        // currA will be either the intersection point or null
        return currA;
    }
}
