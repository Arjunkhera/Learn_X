package com.arjun.introduction;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        introduction();
    }

    public static void introduction() {
        // Empty Optional
        Optional<String> empty = Optional.empty();
        // With value : value cannot be null
        Optional<String> value = Optional.of("Arjun");

        // Check if optional is empty
        System.out.println(empty.isPresent());
        System.out.println(value.isPresent());

        // Assigning possible nullable values
        String str = null;
        Optional<String> output = Optional.ofNullable(str);

        // Obtaining a value from optional
        // throws exception if empty, which is not suitable
        // avoid using this
        System.out.println(value.get());

        // If null, get a default value else return the value
        System.out.println(value.orElse("empty"));

        // We can also use a supplier function with orElseGet
        System.out.println(value.orElseGet(() -> "supplier functions"));

        // for If - Else related statements, Optional provides following
        Optional<String> companyName = Optional.of("Google");
        companyName.ifPresent((name) -> System.out.println(name.length())); // 6

        Optional<String> optName = Optional.ofNullable("Hello World");

        optName.ifPresentOrElse(
                (name) -> System.out.println(name.length()),
                () -> System.out.println(0)
        );
    }
}
