package com.arjun.learn.algorithms.heap;

public class Heap {
  private final int[] heap;
  private int size;
  private final int capacity;

  public Heap() {
    this(32);
  }

  public Heap(int size) {
    this.size = -1;
    this.capacity = size;
    this.heap = new int[this.capacity];
  }

  public int getMin() {
    if(this.size < 0) return -1;
    return this.heap[0];
  }

  public boolean insert(int value) {
    if(this.size + 1 == this.capacity) return false;

    this.size++;
    this.heap[this.size] = value;
    bubbleUp(this.size);
    return true;
  }

  public boolean delete(int value) {
    if(this.size < 0) return false;

    int index = 0;
    for(; index <= this.size && this.heap[index] != value; index++);
    if(index > this.size) return false;

    this.heap[index] = this.heap[this.size];
    this.size--;

    if(value > this.heap[index]) {
      bubbleUp(index);
    } else {
      bubbleDown(index);
    }

    return true;
  }

  public boolean deleteMin() {
    if(this.size < 0) return false;

    this.heap[0] = this.heap[this.size];
    this.size--;
    bubbleDown(0);
    return true;
  }

  private boolean bubbleUp(int index) {
    if(index > this.size || index < 0) return false;

    int value = this.heap[index], parent = (index - 1)/2;
    while(index > 0 && this.heap[parent] > value) {
      this.heap[index] = this.heap[parent];
      index = parent;
      parent = (index - 1)/2;
    }
    this.heap[index] = value;

    return true;
  }

  private boolean bubbleDown(int index) {
    if(index > this.size || index < 0) return false;

    int value = this.heap[index], left, right;
    while(true) {
      left = Integer.MAX_VALUE;
      if(2*index + 1 <= this.size)
        left = this.heap[2*index + 1];

      right = Integer.MAX_VALUE;
      if(2*index + 2 <= this.size)
        right = this.heap[2*index + 2];

      if(value <= left && value <= right)
        break;

      if(value > left) {
        this.heap[index] = left;
        index = 2*index + 1;
      } else {
        this.heap[index] = right;
        index = 2*index + 2;
      }
    }
    this.heap[index] = value;

    return true;
  }

  public void print() {
    for(int i = 0; i <= this.size; i++)
      System.out.printf("%d, ", this.heap[i]);
    System.out.println();
  }

  public static void main(String[] args) {
    Heap heap = new Heap();

    heap.insert(3);
    System.out.printf("get min %d\n", heap.getMin());
    heap.print();

    heap.insert(1);
    System.out.printf("get min %d\n", heap.getMin());
    heap.print();

    heap.insert(5);
    System.out.printf("get min %d\n", heap.getMin());
    heap.print();

    heap.insert(2);
    System.out.printf("get min %d\n", heap.getMin());
    heap.print();

    heap.deleteMin();
    System.out.printf("get min %d\n", heap.getMin());
    heap.print();

    heap.delete(5);
    System.out.printf("get min %d\n", heap.getMin());
    heap.print();
  }
}