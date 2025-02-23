package dsa1;

import java.util.ArrayList;

public class Sorting {
    /*
    Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints

1 <= length of the array <= 105

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the number of inversions of A modulo (109 + 7).



Example Input

Input 1:

A = [1, 3, 2]
Input 2:

A = [3, 4, 1, 2]


Example Output

Output 1:

1
Output 2:

4
     */

    int mod = 1000000007;
    long ans = 0;

    long merge(ArrayList<Integer> A, int s, int mid, int e) {
        int len = e-s+1;
        int[] arr = new int[len];

        int idx = 0;
        int i = s;
        int j = mid+1;
        long cnt = 0L;

        while(i <= mid && j <= e) {
            if(A.get(i) <= A.get(j)) {
                arr[idx] = A.get(i);
                i++;
                idx++;
            } else {
                arr[idx] = A.get(j);
                cnt = mid - i + 1 + cnt;
                j++;
                idx++;
            }
        }

        while(i <= mid) {
            arr[idx] = A.get(i);
            i++;
            idx++;
        }

        while(j <= e) {
            arr[idx] = A.get(j);
            j++;
            idx++;
        }

        idx = 0;
        for(i = s; i <= e; i++) {
            A.set(i, arr[idx++]);
        }
        return cnt;
    }

    long mergeSort(ArrayList<Integer> A, int s, int e) {
        if(s >= e) {
            return 0L;
        }
        int mid = s + (e-s)/2;

        long a = mergeSort(A, s, mid);
        long b = mergeSort(A, mid+1, e);

        long c = merge(A, s, mid, e);
        // System.out.print(a + " " + b + " " + c + " *|* ");

        return ((a + b) % mod + c) % mod;

    }

    public int solve(ArrayList<Integer> A) {
        return (int)mergeSort(A, 0, A.size()-1);
        // return (int)(ans%mod);
    }

}
