package com.arjun.learn.collections;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        //deque();
        //dequeAsStack();
        priorityQueue();
        //priorityQueueCustomComparator();
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
        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x,y) -> -1*Integer.compare(x,y));
        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> -1*Integer.compare(x,y));

        // offer() and add() are used to add elements
        maxHeap.add(51);
        maxHeap.offer(6);
        maxHeap.add(72);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.offer(3);
        maxHeap.offer(4);
        maxHeap.add(11);
        maxHeap.add(19);

        System.out.println("Elements in this queue are: ");
        System.out.println(maxHeap);

        // printing size of the queue
        System.out.println("Size of this queue is: " + maxHeap.size());

        // removing values based on priority and printing them
        System.out.println("Priority Queue:");
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.remove());
        }

    }

    public static void priorityQueueCustomComparator() {
        // Min Heap of euclidean distance
        PriorityQueue<int[]> euclideanDistances = new PriorityQueue<>((p1, p2) -> p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1]);
        // normal queue operations
    }
}
