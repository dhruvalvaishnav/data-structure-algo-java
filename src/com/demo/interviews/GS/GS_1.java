package com.demo.interviews.GS;

// Interview - round 1

/*
   Q : Given a linked list and a positive integer k, find the k'th node from the end of the list.
*/
public class GS_1 {
    public static void main(String[] args) {

        int[] keys = {1, 2, 3, 4, 5, 6, 7};
        Node head = null;

        for (int i = keys.length - 1; i >= 0; i--) {

            head = new Node(keys[i], head);

        }

        int k = 3;

        findKthNode(head, k);

    }

    public static void findKthNode(Node head, int k) {
        int n = 0;
        Node current = head;
        int tempIndex;

        while (current != null) {
            if (current.next == null && n < k) {
                tempIndex = (n - k) + 1;
                current.data = tempIndex;
            }
            n++;
        }

        System.out.println(current.data);

    }
//  1->2->3->4->5->6->7->null
}

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
