package com.arjun.introduction;

public enum Enum {

    FULL(4, "green"),
    HIGH(3, "green"),
    MEDIUM(2, "yellow"),
    LOW(1, "red");

    int sections;
    String color;

    Enum(int sections, String color) {
        this.sections = sections;
        this.color = color;
    }

    public int getSections() {
        return sections;
    }

    public String getColor() {
        return color;
    }

    public static Enum findByColor(String color) {
        for (Enum value: values()) {
            if (color.equals(value.color)) {
                return value;
            }
        }
        return null;
    }
}