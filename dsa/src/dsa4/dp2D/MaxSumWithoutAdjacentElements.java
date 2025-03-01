package dsa4.dp2D;

import java.util.ArrayList;

/*
Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.

Return the maximum possible sum.

Note: You are allowed to choose more than 2 numbers from the grid.
 */
public class MaxSumWithoutAdjacentElements {
    int[] dp;

    public int func(ArrayList<ArrayList<Integer>> A, int i) {
        if(i < 0) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int a = Math.max(A.get(0).get(i), A.get(1).get(i)) + func(A, i-2);
        int b = func(A, i-1);

        return dp[i] = Math.max(a, b);
    }

    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int NA = A.get(0).size();
        dp = new int[NA];

        for(int i = 0; i < NA; i++) {
            dp[i] = -1;
        }

        func(A, NA-1);

        return dp[NA-1];
    }
}
