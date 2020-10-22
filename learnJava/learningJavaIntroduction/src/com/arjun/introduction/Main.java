package com.arjun.introduction;

public class Main {
    public static void main(String[] args) {
        enums();
    }

    public static void enums() {
        // Initialising an enum
        Enum currentChargeLevel = Enum.FULL;

        // accessing the name of enum
        System.out.println(currentChargeLevel.name());

        // accessing enum by its name
        Enum previousChargeLevel = Enum.valueOf("LOW");

        // listing all enum constants, values returns array of enums
        for(Enum val : Enum.values()) {
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
