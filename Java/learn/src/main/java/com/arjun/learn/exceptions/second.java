package com.arjun.exceptions;

public class second {
    public void parentFunction() throws Exception {
        System.out.println("Start parentFunction()");
        childFunction();
        System.out.println("After parentFunction()");
    }

    public void childFunction() throws Exception {
        System.out.println("Start childFunction()");
        throw new Exception("Dummy Exception");
    }
}
