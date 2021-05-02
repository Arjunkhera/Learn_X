package com.arjun.learn;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main( String[] args ) throws IOException {
        myPow(2.0, 1024);
    }

    public static double myPow(double x, int n) {
        double ans = 1;
        if (n < 0) {
            x = 1/x;
            if (n == Integer.MIN_VALUE) {
                ans *= x;
                n >>= 1;
            }
            n = -n;
        }

        while (n > 0) {
            ans = n % 2 == 0 ? ans : ans*x;
            x *= x;
            n >>= 2;
        }

        return ans;
    }
}