package scaler.dsa4.dp2D;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.


Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row

Problem Constraints

|A| <= 1000

A[i] <= 1000



Input Format

First and only argument is the vector of vector A defining the given triangle



Output Format

Return the minimum sum



Example Input

Input 1:


A = [
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:

 A = [ [1] ]


Example Output

Output 1:

 11
Output 2:

 1


 TODO: Trick: Space Complexity can be optimised by using only 1D DP array
 */

import java.util.ArrayList;

public class MinSumPathInATriangle {
    int RA;
    int CA;
    //Basic solution with 2D DP array
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        RA = a.size();
        CA = a.get(RA-1).size();

        int[][] dp = new int[RA][CA];
        dp[0][0] = a.get(0).get(0);

        for(int i = 0; i < RA; i++) {
            for(int j = i+1; j < CA; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < RA; i++) {
            dp[i][0] = dp[i-1][0] + a.get(i).get(0);
        }

        for(int i = 1; i < RA; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + a.get(i).get(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < CA; i++) {
            ans = Math.min(ans, dp[RA-1][i]);
        }

        return ans;

    }



    //TODO: Space Optimised solution

    public int minimumTotalSpaceOptimised(ArrayList<ArrayList<Integer>> a) {
        RA = a.size();
        CA = a.get(RA-1).size();

        int[] dp = new int[CA+1];

        int size = CA;

        for(int i = RA-1; i >= 0; i--) {
            for(int j = 0; j < size; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + a.get(i).get(j);
            }
            size--;
        }

        return dp[0];
    }

}
