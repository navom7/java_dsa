package scaler.dsa4.dp2D;

import java.util.ArrayList;

/*
Rishik likes candies a lot. So, he went to a candy-shop to buy candies.

The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.

Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?


Problem Constraints

1 <= N <= 700

1 <= A[i] <= 1000

1 <= B[i] <= 1000

1 <= C[i],D <= 1000



Input Format

First argument of input is an integer array A
Second argument of input is an integer array B
Third argument of input is an integer array C
Fourth argument of input is an integer D


Output Format

Return a single integer denoting maximum sweetness of the candies that he can buy


Example Input

Input 1:

 A = [1, 2, 3]
 B = [2, 2, 10]
 C = [2, 3, 9]
 D = 8
Input 2:

 A = [2]
 B = [5]
 C = [10]
 D = 99


Example Output

Output 1:

 10
Output 2:

 90
 TODO: Trick is solving it in 1D DP array
 */
public class BuyingCandies {

    //Simple solution with 2D DP array
    public int solve2D_DP(ArrayList<Integer> candies, ArrayList<Integer> sweetness, ArrayList<Integer> cost, int amount) {
        int N = candies.size();
        int[] totalSweetness = new int[N];
        for(int i = 0; i < N; i++) {
            totalSweetness[i] = candies.get(i) * sweetness.get(i);
        }

        int[][] dp = new int[amount+1][N+1];

        for(int paisa = 1; paisa <= amount; paisa++) {
            for(int swt = 1; swt <= N; swt++) {
                int cc = cost.get(swt-1);
                int sweet = totalSweetness[swt-1];

                int a, b=0, c=0;
                a = dp[paisa][swt-1];
                if(cc <= paisa) {
                    b = dp[paisa-cc][swt-1] + sweet;
                    c = dp[paisa-cc][swt] + sweet;
                }
                dp[paisa][swt] = Math.max(a, Math.max(b, c));
            }
        }

        return dp[amount][N];

    }

    //TODO: Most optimised solution
    public int solve(ArrayList<Integer> candies, ArrayList<Integer> sweetness, ArrayList<Integer> cost, int amount) {
        int N = candies.size();
        int[] totalSweetness = new int[N];
        for(int i = 0; i < N; i++) {
            totalSweetness[i] = candies.get(i) * sweetness.get(i);
        }

        int[] dp0 = new int[amount+1];
        int[] dp1 = new int[amount+1];

        for(int swt = 1; swt <= N; swt++) {
            for(int paisa = 1; paisa <= amount; paisa++) {

                int cc = cost.get(swt-1);
                int sweet = totalSweetness[swt-1];

                if(swt % 2 == 0) {

                    int a, b=0, c=0;
                    a = dp1[paisa];
                    if(cc <= paisa) {
                        b = dp1[paisa-cc] + sweet;
                        c = dp0[paisa-cc] + sweet;
                    }
                    dp0[paisa] = Math.max(a, Math.max(b, c));

                } else {

                    int a, b=0, c=0;
                    a = dp0[paisa];
                    if(cc <= paisa) {
                        b = dp0[paisa-cc] + sweet;
                        c = dp1[paisa-cc] + sweet;
                    }
                    dp1[paisa] = Math.max(a, Math.max(b, c));

                }

            }
        }

        return N % 2 == 0 ? dp0[amount] : dp1[amount];

    }
}
