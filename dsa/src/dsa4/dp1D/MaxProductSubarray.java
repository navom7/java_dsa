package dsa4.dp1D;

/*

Problem Description

Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

NOTE: Answer will fit in 32-bit integer value.



Problem Constraints

1 <= N <= 5 * 105

-100 <= A[i] <= 100



Input Format

First and only argument is an integer array A.



Output Format

Return an integer corresponding to the maximum product possible.



Example Input

Input 1:

 A = [4, 2, -5, 1]
Input 2:

 A = [-3, 0, -5, 0]


Example Output

Output 1:

 8
Output 2:

 0

 */

import java.util.List;

public class MaxProductSubarray {

    public int maxProduct(final List<Integer> A) {
        int NA = A.size();
        int[] dp1 = new int[NA];
        int[] dp2 = new int[NA];
        dp1[0] = A.get(0);
        dp2[0] = A.get(0);
        int ans = dp1[0];
        for(int i = 1; i < NA; i++) {
            dp1[i] = Math.min(A.get(i), Math.min(A.get(i)*dp1[i-1], A.get(i)*dp2[i-1]));
            dp2[i] = Math.max(A.get(i), Math.max(A.get(i)*dp1[i-1], A.get(i)*dp2[i-1]));
            ans = Math.max(ans, Math.max(dp1[i], dp2[i]));
        }

        return ans;

    }

}
