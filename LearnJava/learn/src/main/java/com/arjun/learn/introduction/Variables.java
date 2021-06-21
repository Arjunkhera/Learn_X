package com.arjun.learn.introduction;

public class Variables {

  public void introduction() {
    // Declaration
    int a;
    // Initialisation
    a = 12;
    // Declaration and Initialisation
    int b = 13;

    // Automatic Type Inference : Use var
    // Valid for versions including and after java 11
    var checkVariable = "autoAssign";
    System.out.println(checkVariable);
  }

  // Primitive types have their values directly stored in the stack
  // Reference types have their addresses stored for their location in the heap
  // Only reference types can point to null
  // A total of eight primitive types
  public void primitiveTypes() {
    // Boolean
    boolean b = false;
    // Byte
    byte bt = 23;
    // Short : 2 bytes
    short sh = 2;
    // Char : 2 bytes
    char ch = 'c';
    // Integer
    int x = 4;
    // Long
    long y = 5L;
    // Float
    float fl = 3.4f;
    // Double
    double db = 5e-3;
  }

  public void referenceTypes() {
    // Reference Types : usually created through new keyword
    // Name of reference types always starts with a capital letter : like String
    String referenceString = new String("java");
    System.out.println(referenceString);
  }

  public void floatingArithmetic() {
      double d1 = 5 / 4; // 1.0
      double d2 = 5.0 / 4; // 1.25
  }

  public void implicitConversion() {
    int a = 5;
    long A = a;

    // lossy conversion
    long bigLong =  1_200_000_002L;
    float bigFloat = bigLong; // 1.2E9 (= 1_200_000_000)
  }

  public void explicitConversions() {
    double d = 2.00003;

    // it loses the fractional part
    long l =  (long) d; // 2

    // requires explicit casting because long is wider than int
    int i = (int) l; // 2

    // requires explicit casting because the result is long (indicated by L)
    int val = (int) (3 + 2L); // 5

    // casting from a long literal to char
    char ch = (char) 55L; // '7'

    // type overflow
    long bigNum = 100_000_000_000_000L;
    int n = (int) bigNum; // 276447232
  }
}
