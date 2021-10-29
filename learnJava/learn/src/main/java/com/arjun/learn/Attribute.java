package com.arjun.learn;

public class Attribute {
  public String name;
  public String value;

  @Override
  public String toString() {
    return "Attribute{" +
        "name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
  }

  public Attribute(String name, String value) {
    this.name = name;
    this.value = value;
  }
}
