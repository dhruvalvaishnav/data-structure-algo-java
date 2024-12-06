package com.demo.linkedlist;

/* Q. : addTwoNumbers with LinkedList :
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

    Ans::
    The pseudocode is as following:

    Initialize current node to dummy head of the returning list.
    Initialize carry to 00.
    Initialize pp and qq to head of l1l1 and l2l2 respectively.
    Loop through lists l1l1 and l2l2 until you reach both ends.
    Set xx to node pp's value. If pp has reached the end of l1l1, set to 00.
    Set yy to node qq's value. If qq has reached the end of l2l2, set to 00.
    Set sum = x + y + carrysum=x+y+carry.
            Update carry = sum / 10carry=sum/10.
    Create a new node with the digit value of (sum \bmod 10)(summod10) and set it to current node's next, then advance current node to next.
    Advance both pp and qq.
            Check if carry = 1carry=1, if so append a new node with digit 11 to the returning list.
    Return dummy head's next node.
    */

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode();
        l1.push(2);
        l1.push(4);
        l1.push(3);

        ListNode l2 = new ListNode();
        l2.push(5);
        l2.push(6);
        l2.push(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("Output is : " + listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.value : 0;
            int y = (q != null) ? q.value : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next; // Return the next node of the dummy head
    }

    static class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            value = x;
        }

        void push(int x) {
            if (next == null) {
                next = new ListNode(x);
            } else {
                next.push(x);
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                result.append(current.value);
                if (current.next != null) {
                    result.append("->"); // Formatting for the output
                }
                current = current.next;
            }
            return result.toString();
        }
    }
}