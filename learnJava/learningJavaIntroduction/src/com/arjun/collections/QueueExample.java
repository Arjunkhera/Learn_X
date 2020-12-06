package com.arjun.collections;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        deque();
        dequeAsStack();
        priorityQueue();
        priorityQueueCustomComparator();
    }

    public static void deque() {
        Queue<String> q = new ArrayDeque<>();

        q.offer("first");
        q.offer("second");
        q.offer("third");

        System.out.println(q.peek()); // first
        System.out.println(q.peek()); // first
        System.out.println(q.poll()); // first,

        System.out.println(q.peek()); // second
        System.out.println(q.poll()); // second
        System.out.println(q.poll()); // third

        System.out.println(q.isEmpty()); // true
    }

    public static void dequeAsStack() {
        Deque<String> stack = new ArrayDeque<>();

        stack.offerLast("first");
        stack.offerLast("second");
        stack.offerLast("third");

        System.out.println(stack); // [first, second, third]

        System.out.println(stack.pollLast()); // third
        System.out.println(stack.pollLast()); // second
        System.out.println(stack.pollLast()); // first

        System.out.println(stack.pollLast()); // null
    }

    public static void priorityQueue() {
        PriorityQueue<Integer> intQ = new PriorityQueue<>();
        // offer() and add() are used to add elements

        intQ.add(51);
        intQ.offer(6);
        intQ.add(72);
        intQ.add(1);
        intQ.add(2);
        intQ.offer(3);
        intQ.offer(4);
        intQ.add(11);
        intQ.add(19);

        System.out.println("Elements in this queue are: ");
        System.out.println(intQ);

        // printing size of the queue
        System.out.println("Size of this queue is: " + intQ.size());

        // removing values based on priority and printing them
        System.out.println("Priority Queue:");
        while(!intQ.isEmpty()){
            System.out.println(intQ.remove());
        }

    }

    public static void priorityQueueCustomComparator() {
        // Min Heap of euclidean distance
        PriorityQueue<int[]> euclideanDistances = new PriorityQueue<>((p1, p2) -> p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1]);

        // normal queue operations
    }
}
