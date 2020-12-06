package com.arjun.functional.streams;

import com.arjun.functional.examples.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {

    static List<Account> accounts;

    public static void main(String[] args) {
        // Create some random accounts for testing
        accounts = new ArrayList<>();
        Stream.of("Carl", "Rob", "Bob", "Ram", "Shyam")
                .forEach(name -> {
                    accounts.add(new Account(name, Math.random() * 5000));
                });

        reduction();
        collectors();
    }

    public static void reduction() {
        List<Integer> transactions = List.of(20, 40, -60, 5);
        // we get an optional if no identity is provided
        Optional<Integer> result = transactions.stream().reduce(Integer::sum);
        // otherwise directly the object
        Integer answer = transactions.stream().reduce(0, Integer::sum);

        // if the identity is different than stream element, you need a comparator
        Double sumBalance = accounts.stream()
                .reduce(0.0 , (sum, account) -> sum += account.getBalance(), Double::sum);

        Optional<Integer> maxElement = transactions.stream().max(Integer::compareTo);
        IntStream.of(20, 40, -60, 5).max();
    }

    public static void collectors() {
        List<Integer> store = List.of(1,2,3);
        int[] array = new int[]{1,2,3};

        List<Integer> collectedList = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        String str = "arjun";
        str = "khera";

        System.out.println(str);

    }
}
