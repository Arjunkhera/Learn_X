package com.arjun.learn.leetcode;

public class Q50 {

    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println(n);
        System.out.println(-n);
    }

    public static double iterative(double x, int n) {
        long N = n;
        if(n < 0) {
            x = 1/x;
            N = -N;
        }

        double answer = 1;
        for(long i = N; i > 0; i/=2) {
            if(i % 2 == 1) {
                answer *= x;
            }
            x *= x;
        }

        return answer;
    }

//    public static double recursive(double x, int n) {
//
//    }

    public static double bruteForce(double x, int n) {
        if(x == 0) {
            return 0;
        }

        if(n < 0) {
            x = 1/x;
            n = -n;
        }

        double answer = 1;
        for(int i = 0; i < n; i++) {
            answer *= x;
        }

        return answer;
    }
}
