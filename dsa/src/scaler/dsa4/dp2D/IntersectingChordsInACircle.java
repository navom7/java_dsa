package scaler.dsa4.dp2D;


/*
Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.

Two ways are different if there exists a chord which is present in one way and not in other.
Return the answer modulo 109 + 7.



Problem Constraints

1 <= A <= 103



Input Format

The first and the only argument contains the integer A.



Output Format

Return an integer answering the query as described in the problem statement.



Example Input

Input 1:

 A = 1
Input 2:

 A = 2


Example Output

Output 1:

 1
Output 2:

 2
 */

/*
TODO: Think in terms of DP.
    Can we relate answer for N with smaller answers.
    If we draw a chord between any two points, can you observe current set of points getting broken into two smaller sets S_1 and S_2? Can a chord be drawn between two points where each point belong to different set?
    If we draw a chord from a point in S_1 to a point in S_2, it will surely intersect the chord we’ve just drawn.
    So, we can arrive at a recurrence that Ways(n) = sum[i = 0 to n-1] { Ways(i)*Ways(n-i-1) }.
    Here we iterate over i, assuming that size of one of the sets is i and size of other set automatically is (n-i-1) since we’ve already used a pair of points and i pair of points in one set.
    Basically We can use Catalan Number to find out.
 */

public class IntersectingChordsInACircle {

    long mod = 1000000007;
    public int chordCnt(int A) {
        long[] dp = new long[A+1];
        dp[0] = 1L;
        dp[1] = 1L;

        for(int i = 2; i <= A; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += ((dp[j] * dp[i-j-1])%mod);
                dp[i] = dp[i]%mod;
            }
        }
        return (int)dp[A];
    }

}
