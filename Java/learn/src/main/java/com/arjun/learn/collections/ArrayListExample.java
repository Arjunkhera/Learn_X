package com.arjun.collections;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListExample {

    public static void main(String[] args) {
        introduction();
    }

    public static void introduction() {
        // declaring an arrayList
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayWithSize = new ArrayList<>(20);
        // initialising array
        String[] arr = new String[]{"1","2"};
        ArrayList<String> initialisedArray = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> usingListOf = new ArrayList<>(List.of("1","2"));
        ArrayList<Integer> anotherArray = new ArrayList<> () {
            {
                add(1);
                add(2);
            }
        };

        // adding elements to the array
        arrayList.add("1");
        arrayList.add("2");

        java.util.ArrayList<String> prefilledArray = new java.util.ArrayList<>(arrayList);

        // print the contents of the array
        for(String string : arrayList) {
            System.out.println(string);
        }
        System.out.println(arrayList.size());

        arrayList.add(0,"0");
        // get a particular element
        System.out.println(arrayList.get(0));

        java.util.ArrayList<String> anotherArrayList = new java.util.ArrayList<>();
        anotherArrayList.add("a");
        anotherArrayList.add("b");

        // adding another array list
        arrayList.addAll(1, anotherArrayList);
        // both the following lines will give the same output
        System.out.println(arrayList);
        System.out.println(Arrays.toString(arrayList.toArray()));

        arrayList.remove(3);
        System.out.println(arrayList);
        arrayList.set(3, "b");
        System.out.println(arrayList);

        // removes the first occurrence of the matching object
        arrayList.remove("b");
        System.out.println(arrayList);

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("1");
        System.out.println(arrayList);

        System.out.println(arrayList.contains("1"));
        System.out.println(arrayList.indexOf("1"));
        System.out.println(arrayList.lastIndexOf("1"));
        System.out.println(arrayList.indexOf("c"));
    }

    public static void complex() {
        Scanner scanner = new Scanner(System.in);
        java.util.ArrayList<Integer> list1 = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(java.util.ArrayList::new));
        int n = scanner.nextInt();
        int minDistance = list1.stream().map(i -> Math.abs(n - i))
                .min(Comparator.naturalOrder()).orElse(Integer.MAX_VALUE);
        list1.stream().filter(i -> Math.abs(n - i) == minDistance)
                .sorted().forEach(i -> System.out.print(i + " "));

    }
}

class Node<K, V> {
    private K key;
    private V value;

    public Node() {}

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}