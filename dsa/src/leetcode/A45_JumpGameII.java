package leetcode;


/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


TODO: Tricky part is solving it in O(N) time complexity and O(1) space complexity
 */

public class A45_JumpGameII {

    public int jump(int[] nums) {
        int n = nums.length;

         int[] dp = new int[n];
         for(int i = 1; i < n; i++) {
             dp[i] = Integer.MAX_VALUE;
         }

         for(int i = 0; i < n; i++) {
             for(int j = 1; j <= nums[i]; j++) {
                 if(i+j >= n) {
                     break;
                 }
                 dp[i+j] = Math.min(dp[i+j], dp[i]+1);
             }
         }
         return dp[n-1];
    }

    //TODO: Most optimised solution
    public int jumpOptimised(int[] nums) {
        int n = nums.length;
        int near = 0, far = 0, jumps = 0;

        while(far < n-1) {
            int farthest = Integer.MIN_VALUE;
            for(int j = near; j <= far; j++) {
                farthest = Math.max(farthest, j+nums[j]);
            }

            near = far+1;
            far = farthest;
            jumps++;
        }

        return jumps;

    }
}
