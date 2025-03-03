package scaler.dsa4.dp2D;

/*
Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?



Problem Constraints

1 <= A <=18



Input Format

First and only argument is the integer A



Output Format

Return a single integer, the answer to the problem



Example Input

Input 1:

 1
Input 2:

 2


Example Output

Output 1:

 1
Output 2:

 2
 */

public class CatalanNumber {
    public int catalanNumbers(int A) {
        int[] dp = new int[A+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= A; i++) {
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += dp[j]*dp[i-1-j];
            }
            dp[i] = sum;
        }

        return dp[A];
    }
}
