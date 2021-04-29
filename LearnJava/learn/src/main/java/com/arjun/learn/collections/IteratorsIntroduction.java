package com.arjun.learn.collections;

import java.util.*;

public class IteratorsIntroduction {
    public static void main(String[] args) {
        iterator();
        System.out.println("------------");

        enhancedForLoop();
        System.out.println("------------");

        listIterator();
        System.out.println("------------");
    }

    public static void iterator() {
        Iterator<Integer> iteratorOnList = List.of(1,2,3,4,5).iterator();

        while(iteratorOnList.hasNext())
            System.out.printf("%d ", iteratorOnList.next()); // 1 2 3 4 5
        System.out.println("");

        Set<Long> set = new TreeSet<>();
        set.add(10L);
        set.add(5L);
        set.add(18L);
        set.add(14L);
        set.add(9L);

        Iterator<Long> iter = set.iterator();
        while (iter.hasNext()) {
            Long current = iter.next();
            if (current < 10L) {
                iter.remove();
            }
        }

        for(Long lg: set)
            System.out.printf("%d ", lg); // 10 14 18
        System.out.println("");

        Iterator<Long> forEachExample = set.iterator();
        forEachExample.forEachRemaining(element -> System.out.printf("%d ", element)); // 10 14 18
        System.out.println("");
    }

    public static void enhancedForLoop() {
        Iterable<Integer> iterable = List.of(1,2,3);

        // use for each loop
        for(Integer integer : iterable)
            System.out.printf("%d ", integer);
        System.out.println("");

        // use for each method
        iterable.forEach(System.out::println);

        // output order is not guaranteed in sets
        iterable = Set.of(1,2,3);
        iterable.forEach(System.out::println);
    }

    /**
     * ListIterator introduction
     */
    public static void listIterator() {
        List<Integer> list = List.of(1, 2, 3, 4);
        ListIterator<Integer> iterator = list.listIterator(); // only for lists!

        // We can go forward
        while (iterator.hasNext()) {
            System.out.printf("Forward Index: %d Value: %d\n", iterator.nextIndex(), iterator.next());
        }

        // We can go backward
        iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            System.out.printf("Backward Index: %d Value: %d\n", iterator.previousIndex(), iterator.previous());
        }

        System.out.println("--------------------");
        // Optional Methods : will throw UnsupportedOperationException if not implemented
        List<Integer> arrayList = new ArrayList<Integer>(List.of(1,2,3,4));

        ListIterator<Integer> addingElement = arrayList.listIterator();
        // Add element
        addingElement.add(5); // will add 5 before 1
        printList(arrayList);

        ListIterator<Integer> removingElement = arrayList.listIterator();
        removingElement.next();   // will return 5
        removingElement.next();   // will return 1
        removingElement.remove(); // will remove 1
        printList(arrayList);

        ListIterator<Integer> setElement = arrayList.listIterator();
        setElement.next();  // will return 5
        setElement.set(10); // will change 5 to 10
        printList(arrayList);
    }

    public static void printList(List<Integer> list) {
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            System.out.printf("Index: %d Value: %d\n", iterator.nextIndex(), iterator.next());
        }
        System.out.println("--------------------");
    }
}
