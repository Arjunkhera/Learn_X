package com.arjun.introduction;

import java.util.Arrays;

public class ParameterPassing {

    public static void main(String[] args) {

        System.out.println("-----------");
        variableArguments(1, 2, 3, 4);

        System.out.println("-----------");
        testMethod(new int[]{1,2,3});
    }

    // Variable argument should always be used as the last parameter
    // It is treated as an array
    public static void variableArguments(int first, int ... variableArguments) {
        System.out.println(first);
        // Need to convert to string as it is an array
        System.out.println(Arrays.toString(variableArguments));
    }

    public static int testMethod(int[] array, int ... variableArguments) {
        System.out.println(Arrays.toString(variableArguments));

        array[3] = 4;
        return 1;
    }
}
