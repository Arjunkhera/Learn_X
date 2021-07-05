package com.arjun.learn.introduction;

public class Main {

  public static void main(String[] args) {
    // printing();
    numericLiterals();
  }

  // Printing
  public static void printing() {
    Printing printing = new Printing();

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Unformatted Output %n");
    printing.unformattedPrinting();
    System.out.printf("%n[END] Unformatted Output %n");

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Formatted Output %n");
    printing.formattedOutputPrintf();
    System.out.printf("%n[END] Formatted Output %n");
  }

  // Numbers in different bases and their conversions with Strings
  public static void numericLiterals() {
    NumericLiterals numericLiterals = new NumericLiterals();

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Converting Number to String %n");
    numericLiterals.convertNumberToString();
    System.out.printf("%n[END] Converting Number to String %n");

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Converting String to Number %n");
    numericLiterals.convertingStringToNumber();
    System.out.printf("%n[END] Converting String to Number %n");

    System.out.print("-------------------------------");
    System.out.printf("%n[START] Get Binary Array from number 13 %n");
    numericLiterals.getBinaryArrayFromNumber(13);
    System.out.printf("%n[START] Get Binary Array from number -13 %n");
    numericLiterals.getBinaryArrayFromNumber(-13);
    System.out.printf("%n[END] Get Binary Array from number%n");

  }

  public static void enums() {
    // Initialising an enum
    Enum currentChargeLevel = Enum.FULL;

    // accessing the name of enum
    System.out.println(currentChargeLevel.name());

    // accessing enum by its name
    Enum previousChargeLevel = Enum.valueOf("LOW");

    // listing all enum constants, values returns array of enums
    for (Enum val : Enum.values()) {
      System.out.println(val);
    }

    // returning the ordinal position of enum values
    System.out.println(currentChargeLevel.ordinal());
    System.out.println(Enum.MEDIUM.ordinal());

    // comparing enums
    System.out.println(previousChargeLevel.equals(Enum.LOW));
    System.out.println(previousChargeLevel == Enum.LOW);

    // printing field methods of enum
    System.out.println(currentChargeLevel.getColor());
    System.out.println(currentChargeLevel.getSections());
  }
}
