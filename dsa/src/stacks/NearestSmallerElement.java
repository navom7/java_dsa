package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class NearestSmallerElement {

    List<Integer> nearestSmallerElementTowardsLeft(List<Integer> arr) {
        Stack<Integer> st = new Stack<>();

        int n = arr.size();

        int[] ans = new int[n];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(st.isEmpty()) {
                ans[idx++] = -1;
            } else if(st.peek() >= arr.get(i)) {
                while(!st.isEmpty() && st.peek() >= arr.get(i)) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    ans[idx++] = -1;
                } else {
                    ans[idx++] = st.peek();
                }

            } else {
                ans[idx++] = st.peek();
            }

            st.push(arr.get(i));
        }
        return Arrays.stream(ans)
                .boxed()
                .collect(Collectors.toList());
    }



    List<Integer> nearestSmallestElementTowardsLeftIndex(List<Integer> input) {
        Stack<Integer> st = new Stack<>();
        return null;
    }


    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(8,2,4,9,7,5,3,10);
        NearestSmallerElement smallerElement = new NearestSmallerElement();
        List<Integer> ans = smallerElement.nearestSmallerElementTowardsLeft(arr);
        System.out.println("ans is ------");
        for(Integer itr: ans) {
            System.out.print(itr + " ");
        }
    }
}
