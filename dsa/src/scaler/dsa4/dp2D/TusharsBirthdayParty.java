package scaler.dsa4.dp2D;

import java.util.List;

/*
Problem Description

As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.



Problem Constraints

|A| <= 1000

|B| <= 1000

|C| <= 1000



Input Format

First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost



Output Format

Return a single integer, the answer to the problem



Example Input

Input 1:

A = [2, 4, 6]
B = [2, 1, 3]
C = [2, 5, 3]
Input 2:

A = [2]
B = [1]
C = [2]


Example Output

Output 1:

12
Output 2:

4


Example Explanation

Explanation 1:

First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
So 2 + 2*2 + 3*2 = 12.
Explanation 2:

Only way is to take 2 dishes of cost 2, hence 4.
 */
public class TusharsBirthdayParty {

    //TODO: Doing some blunder as everytime only INT_MAX is coming
    int knapsack(int capacity, int i, int n, final List<Integer> fillingCapacities, final List<Integer> cost) {
        if(capacity == 0) {
            return 0;
        }
        if(i == n) {
            return Integer.MAX_VALUE;
        }

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        a = knapsack(capacity, i+1, n, fillingCapacities, cost);

        if(capacity >= fillingCapacities.get(i)) {
            //TODO when i add something to INT_MAX and assign back to an integer it becomes small number
            b = cost.get(i) + knapsack(capacity-fillingCapacities.get(i), i+1, n, fillingCapacities, cost);
            c = cost.get(i) + knapsack(capacity-fillingCapacities.get(i), i, n, fillingCapacities, cost);
        }

        return Math.min(a, Math.min(b, c));

    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> eatingCapacities, final List<Integer> fillingCapacities, final List<Integer> cost) {
        int EN = eatingCapacities.size();
        int FN = fillingCapacities.size();
        int CN = cost.size();
        int ans = 0;
        for(int x: eatingCapacities) {
            int temp = knapsack(x, 0, FN, fillingCapacities, cost);
            // System.out.print(temp + " ");
            ans += temp;

            System.out.print(ans + " ");
        }

        return ans;

    }






    //--------------------------------------//--------------------------------------
    //TODO: again making some mistake
    long[][] dp;
    long knapsack2(int capacity, int i, int n, final List<Integer> fillingCapacities, final List<Integer> cost) {
        if(capacity == 0) {
            return 0;
        }
        if(i == n) {
            return Integer.MAX_VALUE ;
        }
        if(dp[capacity][i] != -1) {
            return dp[capacity][i];
        }

        long a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        a = knapsack(capacity, i+1, n, fillingCapacities, cost);

        if(capacity >= fillingCapacities.get(i)) {
            System.out.print("here");
            b = cost.get(i) + knapsack(capacity-fillingCapacities.get(i), i+1, n, fillingCapacities, cost);
            c = cost.get(i) + knapsack(capacity-fillingCapacities.get(i), i, n, fillingCapacities, cost);
        }

        dp[capacity][i] = Math.min(a, Math.min(b, c));
        return dp[capacity][i];
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve2(final List<Integer> eatingCapacities, final List<Integer> fillingCapacities, final List<Integer> cost) {
        int EN = eatingCapacities.size();
        int FN = fillingCapacities.size();
        int CN = cost.size();
        long ans = 0;
        int max = Integer.MIN_VALUE;
        for(int x: eatingCapacities) {
            max = Math.max(x, max);
        }

        dp = new long[max+1][FN+1];

        for(int i = 0; i <= max; i++) {
            for(int j = 0; j <= FN; j++) {
                dp[i][j] = -1;
            }
        }
        knapsack(max, 0, FN, fillingCapacities, cost);
        // for(int i = 0; i <= max; i++) {
        //     System.out.print(dp[i][FN-1] + " ");
        // }

        for(int x: eatingCapacities) {
            long temp = dp[x][FN-1];
            System.out.print(temp + " ");
            ans += temp;
        }

        return (int)ans;

    }

}
