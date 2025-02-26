package dsa4.dp1D;

/*

Problem Description

You are given an array A of N integers and three integers B, C, and D.

You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.

Input 1:

 A = [1, 5, -3, 4, -2]
 B = 2
 C = 1
 D = -1
Input 2:

 A = [3, 2, 1]
 B = 1
 C = -10
 D = 3


Example Output

Output 1:

 18
Output 2:

 -4


TODO: Trick: At any index i
    for B you should consider  two cases:
        1. Took some previous index(i-n) with B
        2. Taking this A[i] with B
    for C your should consider:
        1. Took previous index with C and hence you are not taking this i
        2. Take this A[i]*C and add this the current value of whatever max is by taking only B
    for D:
        same way as C just this time you should consider the C in place of D wala value



 */

import java.util.ArrayList;

public class MaximumSumValue {
    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int NA = A.size();
        int[][] dp = new int[NA][3];

        for(int i = 0; i < NA; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = B*A.get(0);
        dp[0][1] = dp[0][0] + C*A.get(0);
        dp[0][2] = dp[0][1] + D*A.get(0);

        for(int i = 1; i < NA; i++) {
            dp[i][0] = Math.max(dp[i-1][0], B*A.get(i));
            dp[i][1] = Math.max(dp[i-1][1], dp[i][0] + C*A.get(i));
            dp[i][2] = Math.max(dp[i-1][2], dp[i][1] + D*A.get(i));
        }

        return dp[NA-1][2];
    }
}
