package com.arjun.learn.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    // iteratorsIntroduction();
    // collectionIntroduction();
    // queueIntroduction();

    int a = 5;
    int b = 2;
    System.out.println((double)a/b);
    Double d = (double) Integer.MIN_VALUE;
    int[] arr = new int[]{1,2};
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>(list);

  }

  public static void iteratorsIntroduction() {
    IteratorsIntroduction iteratorsIntroduction = new IteratorsIntroduction();

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Iterator Introduction %n");
    iteratorsIntroduction.iterator();
    System.out.printf("%n[END] Iterator Introduction %n");

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Enhanced For Loop %n");
    iteratorsIntroduction.enhancedForLoop();
    System.out.printf("%n[END] Enhanced For Loop %n");

    System.out.print("-------------------------------");
    System.out.printf("%n[START] List Iterator %n");
    iteratorsIntroduction.listIterator();
    System.out.printf("%n[END] List Iterator %n");
  }

  public static void collectionIntroduction() {
    CollectionInterface collectionInterface = new CollectionInterface();

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Collection Introduction %n");
    collectionInterface.introduction();
    System.out.printf("%n[END] Collection Introduction %n");
  }

  public static void queueIntroduction() {
    QueueIntroduction queueIntroduction = new QueueIntroduction();

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Queue Introduction %n");
    queueIntroduction.queueInterface();
    System.out.printf("%n[END] Queue Introduction %n");

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Priority Queue Introduction %n");
    queueIntroduction.priorityQueue();
    System.out.printf("%n[END] Priority Queue Introduction %n");

  }
}
