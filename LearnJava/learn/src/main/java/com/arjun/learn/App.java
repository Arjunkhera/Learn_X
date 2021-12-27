package com.arjun.learn;

import com.arjun.learn.Test.InnerStaticClass;
import java.io.IOException;
import java.util.List;

public class App {
  public static void main(String[] args) throws IOException {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

    System.out.println(numbers.stream()
        .filter(App::evenCheck)
        .filter(App::gt3)
        .map(App::doDouble)
        .findFirst());

  }

  private static boolean evenCheck(int number) {
    System.out.println("Even check for: " + number);
    return number % 2 == 0;
  }

  private static boolean gt3(int number) {
    System.out.println("Greater check for: " + number);
    return number > 3;
  }

  private static int doDouble(int number) {
    System.out.println("Double value for: " + number);
    return number * 2;
  }

}

