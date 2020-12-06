package com.arjun.competitive.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList dummy = new SingleLinkedList();
        SingleLinkedList current = dummy;

        // Create a random linked list
        for(int i = 1; i < 10; i++) {
            current.next = new SingleLinkedList(i);
            current = current.next;
        }

        SingleLinkedList head = dummy.next;

        printLinkedList(head);
        System.out.println("Length: " + findLength(head));

        System.out.println("Inserting 0 at head");
        head = insertAtHead(0, head);
        printLinkedList(head);

        System.out.println("Inserting 11 at tail");
        head = insertAtTail(11, head);
        printLinkedList(head);

        System.out.println("Inserting 5 after index 4");
        insertAfter(4, 5, head);
        printLinkedList(head);

        System.out.println("Delete index 11");
        head = deleteIndex(11, head);
        printLinkedList(head);

        System.out.println("Delete key at node 5");
        head = deleteKey(5, head);
        printLinkedList(head);

        printNthNodeFromEnd(1, head);
        printMiddleElementLinkedList(head);
    }
    
    public static boolean findLoopInListHashMap(SingleLinkedList head) {
        Set<SingleLinkedList> visited = new HashSet<>();
        while(head != null) {
            if(visited.contains(head)) return true;

            visited.add(head);
            head = head.next;
        }

        return false;
    }

    public static void printMiddleElementLinkedList(SingleLinkedList head) {
        if(head == null) return;
        SingleLinkedList slow = head;
        SingleLinkedList fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.value);
    }

    public static void printNthNodeFromEnd(int distance, SingleLinkedList head) {
        int providedDistance = distance;
        SingleLinkedList forward = head;
        while(forward != null && distance != 0) {
            forward = forward.next;
            distance--;
        }
        if(forward == null) return;

        SingleLinkedList current = head;
        while(forward != null) {
            forward = forward.next;
            current = current.next;
        }
        System.out.println(providedDistance + "th node from the end is " + current.value);
    }

    public static SingleLinkedList deleteKey(int key, SingleLinkedList head) {
        SingleLinkedList dummy = new SingleLinkedList(0, head);
        SingleLinkedList prev = dummy;
        SingleLinkedList current = head;

        while(current != null && current.value != key) {
            prev = prev.next;
            current = current.next;
        }

        if(current == null) return head;
        prev.next = current.next;
        current.next = null;
        return dummy.next;
    }

    public static SingleLinkedList deleteIndex(int index, SingleLinkedList head) {
        if(head == null) return null;

        SingleLinkedList dummy = new SingleLinkedList(0, head);
        SingleLinkedList prev = dummy;
        SingleLinkedList current = head;

        while(index != 0) {
            if(current == null) return dummy.next;
            index--;
            prev = prev.next;
            current = current.next;
        }

        prev.next = current.next;
        current.next = null;
        return dummy.next;
    }

    public static void insertAfter(int index, int value, SingleLinkedList head) {
        if(head == null) return;

        while(index != 0) {
            index--;
            head = head.next;
        }

        SingleLinkedList newNode = new SingleLinkedList(value, head.next);
        head.next = newNode;
    }

    public static SingleLinkedList insertAtTail(int value, SingleLinkedList head) {
        SingleLinkedList newNode = new SingleLinkedList(value);
        if(head == null) return newNode;

        SingleLinkedList tail = head;
        while(tail.next != null) tail = tail.next;
        tail.next = newNode;
        return head;
    }

    public static SingleLinkedList insertAtHead(int value, SingleLinkedList head) {
        return new SingleLinkedList(value, head);
    }

    public static int findLength(SingleLinkedList head) {
        int length = 0;
        while(head != null) {
            length += 1;
            head = head.next;
        }

        return length;
    }

    public static void printLinkedList(SingleLinkedList head) {
        while(head.next != null) {
            System.out.print(head.value + " --> ");
            head = head.next;
        }
        System.out.println(head.value);
    }
}
