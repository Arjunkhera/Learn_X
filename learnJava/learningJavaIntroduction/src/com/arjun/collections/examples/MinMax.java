package com.arjun.collections.examples;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        List<? extends T> sortedList = stream.sorted(order).collect(Collectors.toList());
        if (sortedList.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(sortedList.get(0), sortedList.get(sortedList.size() - 1));
        }
    }

    public static <T> void findMinMax2(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        var o = new Consumer<T>() {
            T min = null;
            T max = null;

            @Override
            public void accept(T t) {
                if (min == null) {
                    min = max = t;
                } else if (order.compare(t, min) < 0) {
                    min = t;
                } else if (order.compare(t, max) > 0) {
                    max = t;
                }
            }
        };
        stream.forEach(o);
        minMaxConsumer.accept(o.min, o.max);
    }

    public static <T> void findMinMax3(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        ArrayDeque<T> deque = stream.sorted(order).collect(Collectors.toCollection(ArrayDeque::new));
        minMaxConsumer.accept(deque.peekFirst(), deque.peekLast());
    }

    public static <T> void findMinMax4(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> st = stream.collect(Collectors.toList());
        minMaxConsumer.accept(st.stream().min(order).orElse(null),
                st.stream().max(order).orElse(null));
    }
}
