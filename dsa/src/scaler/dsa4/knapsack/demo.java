package scaler.dsa4.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        List<Integer> starting = new ArrayList<>(Arrays.asList(0, 5, 10, 15));
        List<Integer> end = new ArrayList<>(Arrays.asList(5, 10, 15, 20));
        int k = 1;
        int n = starting.size();

        Collections.sort(starting);
        Collections.sort(end);

        int runCount = 0;

        int i = 0, j = 0;

        while(i < n) {
            if(starting.get(i) < end.get(j)) {
                runCount++;
                i++;
                if(runCount > k) {
                    System.out.println("False");
                    return;
                }
            } else {
                j++;
                runCount = 0;
            }
        }

        System.out.println("True");
        return;













//        List<Integer> arr = new ArrayList<>(Arrays.asList(2,5, 7, 7, 4));
//        List<Integer> arr = new ArrayList<>(Arrays.asList(1,5,3,1));
//        List<Integer> arr = new ArrayList<>(Arrays.asList(3,0,8,2,5,1,4));
//
//        int n = arr.size();
//
//        int[] ans = new int[n];
//        for(int i = 0; i < n; i++) {
//            ans[i] = 1;
//        }
//
//        for(int i = 1; i < n; i++) {
//            int num = arr.get(i);
//            int prevNum = arr.get(i-1);
//
//            if(num > prevNum) {
//                ans[i] = ans[i-1]+1;
//                if(i < n-1 && arr.get(i+1) < num) {
//                    ans[i]++;
//                }
//            }
//            if(num == prevNum) {
//                ans[i] = ans[i-1];
//            }
//        }
//
//        for(int i = 0; i < n; i++) {
//            System.out.print(ans[i] + " ");
//        }
    }
}
