package dsa4.dp1D;


/*

You are climbing a staircase and it takes A steps to reach the top.


Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007


TODO: Trick: Trick is in taking mod, as mod has modulo distribution property and we can take modulo at each step of calculating the number
 */

public class Stairs {


    public int climbStairs(int A) {
        long mod = 1000000007;
        long a = 1;
        long b = 1;
        long c = 1;
        for(int i = 2; i <= A; i++) {
            c = a + b;
            c = c % mod;
            a = b;
            b = c;
        }

        return (int)(c % mod);
    }

}
