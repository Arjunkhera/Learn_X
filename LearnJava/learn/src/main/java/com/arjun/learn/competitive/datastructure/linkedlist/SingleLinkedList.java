package com.arjun.competitive.datastructure.linkedlist;

public class SingleLinkedList {
    public int value;
    public SingleLinkedList next;

    public SingleLinkedList() {
        this.next = null;
    }
    public SingleLinkedList(int value) {
        this.value = value;
        this.next = null;
    }
    public SingleLinkedList(int value, SingleLinkedList next) {
        this.value = value;
        this.next = next;
    }
}
