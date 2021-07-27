package com.arjun.learn.collections;

public class Main {

  public static void main(String[] args) {
    // iteratorsIntroduction();
    // collectionIntroduction();
    queueIntroduction();
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
  }
}
