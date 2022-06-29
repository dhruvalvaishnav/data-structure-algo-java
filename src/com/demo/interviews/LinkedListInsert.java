package com.demo.interviews;

public class LinkedListInsert {

    Node head;

    static class Node {
        int data;
        Node next;
    }

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node node1 = head;
            while (node1.next != null) {
                node1 = node1.next;
            }
            node1.next = node;
        }
    }

    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.print(" -> " + node.data);
            node = node.next;
        }
        System.out.print(" -> " + node.data);
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtStart(data);
        } else {
            Node node1 = new Node();
            node1.data = data;
            node1.next = null;
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node1.next = node.next;
            node.next = node1;

        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node node = head;
            Node node1 = null;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node1 = node.next;
            node.next = node1.next;
            node1 = null;
        }
    }

    public static void main(String[] args) {
        LinkedListInsert linkList1 = new LinkedListInsert();
        linkList1.insert(2);
        linkList1.insert(3);
        linkList1.insert(4);
        linkList1.insert(5);

        linkList1.insertAtStart(1);

        linkList1.insertAt(2, 10);

        linkList1.deleteAt(2);

        linkList1.show();
    }
}

