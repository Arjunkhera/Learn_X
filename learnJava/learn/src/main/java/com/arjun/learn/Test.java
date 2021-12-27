package com.arjun.learn;

public class Test {

  InnerStaticClass innerStaticClass;

  public Test() {
    innerStaticClass = new InnerStaticClass();
  }

  public static void main(String[] args) {
  }

  public void testMethod() {
    innerStaticClass.privateField = 3;
  }

  public class InnerStaticClass {
    private int privateField;
    public int fieldName;

    public int getFieldName() {
      return fieldName;
    }

    public void setFieldName(int fieldName) {
      this.fieldName = fieldName;
    }
  }
}
