package com.arjun.learn.algorithms.queue;

import java.util.Arrays;

public class Queue {
  int[] data;
  private static final int defaultSize = 32;
  int left = 0, right = -1, size = 0, capacity;

  public Queue() {
    this(defaultSize);
  }

  public Queue(int capacity) {
    this.capacity = capacity;
    this.data = new int[this.capacity];
  }

  public boolean offer(int element) {
    if(size == capacity) return false;

    right = (right + 1) % capacity;
    data[right] = element;
    size++;

    return true;
  }

  public int poll() {
    if(size == 0) return -1;

    int element = data[left];

    if(size == 1) {
      left = 0;
      right = -1;
    } else {
      left = (left + 1) % capacity;
    }
    size--;

    return element;
  }

  public int peek() {
    if(size == 0) return -1;
    return data[left];
  }

  public void print() {
    System.out.printf("%s\n", Arrays.toString(data));
  }

}
