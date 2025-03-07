package scaler.dsa4.knapsack;

import java.util.ArrayList;

/*
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints

1 <= N <= 103

1 <= C <= 103

1 <= A[i], B[i] <= 103



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 220
Output 2:

 0
 */
public class BinaryKnapsack_0_1 {
    int knapsack(ArrayList<Integer> weight, ArrayList<Integer> values, int capacity, int n, int[][] dp) {
        if(n == 0) {
            return 0;
        }
        if(dp[capacity][n] != -1) {
            // System.out.print(dp[capacity][n] + " ");
            return dp[capacity][n];
        }
        int v1 = knapsack(weight, values, capacity, n-1, dp);
        int v2 = 0;
        if(weight.get(n-1) <= capacity) {
            v2 = knapsack(weight, values, capacity - weight.get(n-1), n-1, dp) + values.get(n-1);
        }

        dp[capacity][n] = Math.max(v1, v2);
        return dp[capacity][n];
    }

    //TODO; Recursive solution 2D DP
    public int knapsackRecursive_2D_DP(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n = A.size();
        int[][] dp = new int[C+1][n+1];

        for(int i = 0; i <= C; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return knapsack(B, A, C, A.size(), dp);
    }


    //TODO: Iterative Approach with 2D DP array
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int N = A.size();
        int[][] dp = new int[C+1][N+1];

        for(int c = 1; c <= C; c++) {
            for(int n = 1; n <= N; n++) {
                int f1 = dp[c][n-1];
                int f2 = 0;
                if(B.get(n-1) <= c) {
                    f2 = dp[c-B.get(n-1)][n-1] + A.get(n-1);
                }

                dp[c][n] = Math.max(f1, f2);
            }
        }

        return dp[C][N];
    }

    //TODO: Iterative Approach with 1D DP array
    public int knapsackIterativeOptimised(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int N = A.size();
        int[] dp = new int[C+1];

        for(int c = 1; c <= C; c++) {
            for(int n = 1; n <= N; n++) {

                int f1 = dp[c][n-1];
                int f2 = 0;

                if(B.get(n-1) <= c) {
                    f2 = dp[c-B.get(n-1)][n-1] + A.get(n-1);
                }

                dp[c][n] = Math.max(f1, f2);
            }
        }

        return dp[C][N];
    }


}
