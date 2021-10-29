package com.arjun.learn.algorithms.heap;

public class Heap {

  int[] heap;
  int sz, last;

  public Heap(int n) {
    this.heap = new int[n];
    this.sz = n;
    this.last = -1;
  }

  public int min() {
    if (this.last == -1) {
      return -1;
    }
    return this.heap[0];
  }

  public boolean insert(int data) {
    if (this.last + 1 == this.sz) {
      return false;
    }

    this.last += 1;
    this.heap[this.last] = data;
    bubbleUp(this.last);
    return true;
  }

  public boolean removeMin() {
    if (this.last == -1) {
      return false;
    }

    this.heap[0] = this.heap[this.last--];
    bubbleDown(0);
    return true;
  }

  public boolean removeAny(int data) {
    if (this.last == -1) {
      return false;
    }

    int i = 0;
    for (; i <= this.last && this.heap[i] != data; i++) {
      ;
    }
    // element does not exist in heap
    if (i > this.last) {
      return false;
    }

    if (this.heap[i] < this.heap[this.last]) {
      this.heap[i] = this.heap[this.last--];
      bubbleDown(i);
    } else {
      this.heap[i] = this.heap[this.last--];
      bubbleUp(i);
    }

    return true;
  }

  public boolean heapify(int[] input) {
    if (input.length > this.sz) {
      return false;
    }

    for (int val : input) {
      this.heap[++this.last] = val;
    }

    for (int i = (this.last + 1) / 2; i >= 0; i--) {
      bubbleDown(i);
    }
    return true;
  }

  private void bubbleUp(int idx) {
    int current = idx, val = this.heap[idx], parent;
    while (current > 0) {
      parent = (current - 1) / 2;
      if (this.heap[parent] > val) {
        this.heap[current] = this.heap[parent];
        current = parent;
      } else {
        break;
      }
    }

    this.heap[current] = val;
  }

  private void bubbleDown(int idx) {
    int current = idx, val = this.heap[idx], chleft, chright;
    while (current < this.last) {
      chleft = 2 * current + 1;
      if (chleft > this.last) {
        break;
      }
      if (this.heap[chleft] < val) {
        this.heap[current] = this.heap[chleft];
        current = chleft;
        continue;
      }

      chright = 2 * current + 2;
      if (chright > this.last) {
        break;
      }
      if (this.heap[chright] < val) {
        this.heap[current] = this.heap[chright];
        current = chright;
        continue;
      } else {
        break;
      }
    }

    this.heap[current] = val;
  }

  public void print() {
    for (int i = 0; i <= this.last; i++) {
      System.out.printf("%d, ", this.heap[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Heap heap = new Heap(10);

    heap.heapify(new int[]{3, 4, 1, 7, 10, 12, 6, 2});
    System.out.println(heap.min());

    heap.removeMin();
    heap.print();

    heap.insert(2);
    heap.print();

    heap.removeAny(1);
    heap.print();
  }
}
