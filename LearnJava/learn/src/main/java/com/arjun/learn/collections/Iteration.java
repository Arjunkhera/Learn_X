package com.arjun.collections;

import java.util.*;

public class Iteration {
    public static void main(String[] args) {
        // introduction();
        // usingIterator();
        listIterator();
    }

    public static void introduction() {
        Iterable<Integer> iterable = List.of(1,2,3);

        // use for each loop
        for(Integer integer : iterable) {
            System.out.println(integer);
        }
        // use for each method
        iterable.forEach(System.out::println);

        // output order is not guaranteed in sets
        iterable = Set.of(1,2,3);
        iterable.forEach(System.out::println);
    }

    public static void usingIterator() {
        Set<Long> set = new TreeSet<>();
        set.add(10L);
        set.add(5L);
        set.add(18L);
        set.add(14L);
        set.add(9L);

        System.out.println(set);

        Iterator<Long> iter = set.iterator();
        while (iter.hasNext()) {
            Long current = iter.next();
            if (current < 10L) {
                iter.remove();
            }
        }

        System.out.println(set);
    }

    public static void listIterator() {
        List<Integer> list = List.of(1, 2, 3, 4);
        ListIterator<Integer> iterator = list.listIterator(); // only for lists!

        // go to the last element
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // another way is to directly use the index
        iterator = list.listIterator(list.size());

        // print elements in the backward order with their indexes
        while (iterator.hasPrevious()) {
            int previousIndex = iterator.previousIndex();
            int element = iterator.previous();
            System.out.println(element + " on " + previousIndex);
        }
    }
}
