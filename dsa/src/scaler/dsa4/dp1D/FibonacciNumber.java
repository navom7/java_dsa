package scaler.dsa4.dp1D;


/*
Problem Description

Given a positive integer A, write a program to find the Ath Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0th term is 0. 1th term is 1 and so on.
 */

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if(n < 2) {
            System.out.print(n);
            return;
        }

        int a = 0;
        int b = 1;
        int c = 1;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        System.out.print(c);
    }

}
