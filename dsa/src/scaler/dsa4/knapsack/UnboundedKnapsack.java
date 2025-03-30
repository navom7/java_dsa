package scaler.dsa4.knapsack;

import java.util.ArrayList;

/*

Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints

1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000



Input Format

First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C



Output Format

Return the maximum value that fills the knapsack completely



Example Input

Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output

Output 1:

 5
Output 2:

14

TODO: Most optimised solution is using O(N) space

 */
public class UnboundedKnapsack {
    int[][] dp;

    public int ubKnapsack(ArrayList<Integer> values, ArrayList<Integer> weights, int capacity, int n) {
        if(n == 0 || capacity == 0) {
            return 0;
        }

        if(dp[capacity][n] != -1) {
            return dp[capacity][n];
        }

        int a = ubKnapsack(values, weights, capacity, n-1);
        int b = 0, c = 0;
        if(weights.get(n-1) <=  capacity) {
            b = ubKnapsack(values, weights, capacity-weights.get(n-1), n-1) + values.get(n-1);
            c = ubKnapsack(values, weights, capacity-weights.get(n-1), n) + values.get(n-1);
        }

        dp[capacity][n] = Math.max(a, Math.max(b, c));
        return dp[capacity][n];
    }


    public int recursiveSolution(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int N = B.size();
        dp = new int[A+1][N+1];

        for(int i = 1; i <= A; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = -1;
            }
        }

        return ubKnapsack(B, C, A, N);

    }


    public int iterativeSolution_2D_DP(int cap, ArrayList<Integer> values, ArrayList<Integer> weights) {
        int N = values.size();
        int[][] dp1 = new int[cap+1][N+1];

        for(int c = 1; c <= cap; c++) {

        }

        return 4;
    }


}
