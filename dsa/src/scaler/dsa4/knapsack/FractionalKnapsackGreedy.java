package scaler.dsa4.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:

You can break an item for maximizing the total value of the knapsack



Problem Constraints

1 <= N <= 105

1 <= A[i], B[i] <= 103

1 <= C <= 103




Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.




Output Format

Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10
 */
public class FractionalKnapsackGreedy {
    class Pair{
        double value;
        double weight;
        double ratio;

        Pair(double a, double b, double r) {
            value = a;
            weight = b;
            ratio = r;
        }
    }

    class CustomComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return Double.compare(b.ratio, a.ratio);
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        List<Pair> arr = new ArrayList<>();

        int n = A.size();

        for(int i = 0; i < n; i++) {
            double value = ((double)A.get(i))/1.0;
            double weight = ((double)B.get(i))/1.0;

            double ratio = value/weight;

            arr.add(new Pair(value, weight, ratio));
        }

        Collections.sort(arr, new CustomComparator());

        int ans = 0;

        for(int i = 0; i < n; i++) {
            Pair p = arr.get(i);
            double value = p.value;
            double weight = p.weight;
            double ratio = p.ratio;

            if(weight <= C) {
                C -= weight;
                ans = ans+(int)(value*100);
            } else {
                // System.out.print(ratio + " ");
                ans += C * (ratio * 100);
                return ans;
            }

        }

        return ans;
    }
}
