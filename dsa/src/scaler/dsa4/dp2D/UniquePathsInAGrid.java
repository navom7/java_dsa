package scaler.dsa4.dp2D;

/*
Problem Description

Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids.
Return the total number unique paths from (1, 1) to (n, m).

Note:
1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
2. Given Source Point and Destination points are 1-based index.
 */

import java.util.ArrayList;

public class UniquePathsInAGrid {
    int RA;
    int CA;
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        RA = A.size();
        CA = A.get(0).size();

        int[][] dp = new int[RA][CA];

        for(int i = 0; i < RA; i++) {
            for(int j = 0; j < CA; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i = 0; i < CA; i++) {
            if(A.get(0).get(i) == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for(int i = 0; i < RA; i++) {
            if(A.get(i).get(0) == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 1; i < RA; i++) {
            for(int j = 1; j < CA; j++) {
                if(A.get(i).get(j) == 0) {
                    dp[i][j] = 0;
                    if(dp[i-1][j] > 0) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if(dp[i][j-1] > 0) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }

        if(dp[RA-1][CA-1] > 0) {
            return dp[RA-1][CA-1];
        }
        return 0;

    }
    
}
